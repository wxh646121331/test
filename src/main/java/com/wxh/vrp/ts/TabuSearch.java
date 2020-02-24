package com.wxh.vrp.ts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/19
 * @time: 下午3:06
 */
public class TabuSearch {
    /**
     * 车辆的容量
     */
    private static final double CAPACITY = 200;

    private static final double MAX_ALPHA = 2000;

    private static final double MIN_ALPHA = 0.001;

    public static final double MAX_BETA = 2000;

    public static final double MIN_BETA = 0.001;

    private static Customer DEPOT;

    private static List<Customer> CUSTOMERS = new ArrayList<>();

    private static List<Route> routes = new ArrayList<>();
    /**
     * 车辆数上限
     */
    private static int MAX_VEHICLE_COUNT;
    /**
     * 禁忌表，用于禁忌节点插入操作
     */
    private static int[][] TABU;

    /**
     * 禁忌表：用于禁忌拓展新路径或使用新车辆
     */
    private static int[] TABU_CREATE;

    private static double ALPHA = 1;
    private static double BETA = 1;
    private static double SITA = 0.5;
    private static double GRAPH[][];
    public static void main(String[] args) {
        System.out.println(DEPOT);
        System.out.println(CUSTOMERS);
    }

    static {
        importCustomers();
        // 由于无车辆数据限制，因此将车辆数上限设置为客户总数
        MAX_VEHICLE_COUNT = CUSTOMERS.size();
        TABU = new int[MAX_VEHICLE_COUNT + 10][MAX_VEHICLE_COUNT + 10];
        TABU_CREATE = new int[MAX_VEHICLE_COUNT + 10];
        GRAPH = new double[CUSTOMERS.size()+1][CUSTOMERS.size()+1];
        // 仓库到客户的距离
        for(int i=0; i<CUSTOMERS.size(); i++){
            GRAPH[0][i+1] = distance(DEPOT, CUSTOMERS.get(i));
            GRAPH[i+1][0] = GRAPH[0][i+1];
        }

        // 客户之间的距离
        for(int i=0; i<CUSTOMERS.size()-1; i++){
            for(int j=i+1; j<CUSTOMERS.size(); j++){
                GRAPH[i+1][j+1] = distance(CUSTOMERS.get(i), CUSTOMERS.get(j));
                GRAPH[j+1][i+1] = GRAPH[i+1][j+1];
            }
        }

        // 初始化每条路径，默认路径收尾为仓库，且首仓库最早最晚时间均仓库最早时间，尾仓库最早最晚时间均为原仓库最晚时间

    }

    private static double distance(Customer c1, Customer c2){
        return Math.sqrt((c1.getX()-c2.getX())*(c1.getX()-c2.getX()) + (c1.getY()-c2.getY())*(c1.getY()-c2.getY()));
    }



    /**
     * 计算目标函数的值，目标函数主要由三个部分组成：
     *     1. D: 路径总长度（优化目标）
     *     2. Q: 超出容量约束总量
     *     3. T: 超出时间窗约束总量
     * 目标函数结构为 f(R) = D + Alpha * Q + Beta * T，第一项为问题最小化目标，后两项为惩罚部分
     *     其中 Alpha 与 Beta 为可变参数，分别根据当前解是否满足两个约束来进行变化
     * @param routes 线路列表
     * @param cusIndex 被移除和插入的节点下标
     * @param newRouteIndex 被插入的路线下标
     * @return
     */
    private static double calculation(List<Route> routes, int cusIndex, int newRouteIndex){
        double T = 0;
        double Q = 0;
        double D = 0;
        // 计算路径超出容量约束的总量
        for( int i=0; i< MAX_VEHICLE_COUNT; i++){
            Route route = routes.get(i);
            if(route.getCustomerList().size() >2 && route.getLoad() > CAPACITY){
                Q = Q + route.getLoad() - CAPACITY;
            }
        }
        // 计算单条路径上各个节点超出时间窗约束的总量（仅更新进行移除和插入节点操作的两个线路）
        Customer customer = CUSTOMERS.get(cusIndex);
        Route oldRoute = routes.get(customer.getRouteId());
        resetSubTime(oldRoute);
        Route newRoute = routes.get(newRouteIndex);
        resetSubTime(newRoute);

        for(Route route : routes){
            T += route.getSubTime();
            D += route.getDistance();
        }
        return D + ALPHA * Q + BETA * T;
    }

    private static boolean check(List<Route> routes){
        double T = 0;
        double Q = 0;
        double D = 0;
        for(Route route : routes){
            if(route.getCustomerList().size() > 2 && route.getLoad() > CAPACITY){
                Q = Q + route.getLoad() - CAPACITY;
            }
            T += route.getSubTime();
        }
        // 分别根据约束条件的情况更新 ALPHA 和 BETA 的值
        if(Q==0 && ALPHA >= MIN_ALPHA){
            ALPHA /= (1 + SITA);
        }else if(Q != 0 && ALPHA <= MAX_ALPHA){
            ALPHA *= (1 + SITA);
        }
        if(T==0 && BETA >= MIN_BETA){
            BETA /= (1+SITA);
        }else if(T!=0 && BETA<=MAX_BETA){
            BETA *= (1 + SITA);
        }

        if(T == 0 && Q == 0){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 重新计算线路超时总量
     * @param route
     */
    private static void resetSubTime(Route route){
        double arriveTime = 0;
        double subTime = 0;
        List<Customer> customers = route.getCustomerList();
        for(int i=1; i<customers.size(); i++){
            arriveTime = arriveTime + customers.get(i-1).getServer() + GRAPH[customers.get(i-1).getId()][customers.get(i).getId()];
            if(arriveTime > customers.get(i).getEnd()){
                subTime = subTime + arriveTime - customers.get(i).getEnd();
            }else if(arriveTime < customers.get(i).getBegin()){
                arriveTime = route.getCustomerList().get(i).getBegin();
            }
        }
        route.setSubTime(subTime);
    }

    /**
     * 读入数据
     */
    private static void importCustomers(){
        try(
                FileReader fr = new FileReader("R101.txt");
                BufferedReader br = new BufferedReader(fr)
        ){
            String line = br.readLine();
            DEPOT = valueOf(line);
            DEPOT.setRouteId(-1);
            while (null != (line = br.readLine())){
                CUSTOMERS.add(valueOf(line));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 将文件中的一行数据转换成一个客户对象
     * 包含字段：id, x, y, demand, start, end, server_time
     * @param line
     * @return
     */
    private static Customer valueOf(String line){
        String[] sub = line.trim().split(" ");
        Customer customer = new Customer();
        customer.setId(Integer.valueOf(sub[0]));
        customer.setX(Double.valueOf(sub[1]));
        customer.setY(Double.valueOf(sub[2]));
        customer.setDemand(Double.valueOf(sub[3]));
        customer.setBegin(Double.valueOf(sub[4]));
        customer.setEnd(Double.valueOf(sub[5]));
        customer.setServer(Double.valueOf(sub[6]));
        return customer;
    }

}

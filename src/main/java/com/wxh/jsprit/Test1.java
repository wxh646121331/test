package com.wxh.jsprit;

import com.alibaba.fastjson.JSON;
import com.graphhopper.jsprit.analysis.toolbox.GraphStreamViewer;
import com.graphhopper.jsprit.analysis.toolbox.Plotter;
import com.graphhopper.jsprit.core.algorithm.VehicleRoutingAlgorithm;
import com.graphhopper.jsprit.core.algorithm.box.Jsprit;
import com.graphhopper.jsprit.core.problem.Location;
import com.graphhopper.jsprit.core.problem.VehicleRoutingProblem;
import com.graphhopper.jsprit.core.problem.job.Service;
import com.graphhopper.jsprit.core.problem.solution.VehicleRoutingProblemSolution;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleImpl;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleType;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleTypeImpl;
import com.graphhopper.jsprit.core.reporting.SolutionPrinter;
import com.graphhopper.jsprit.core.util.Solutions;
import com.graphhopper.jsprit.io.problem.VrpXMLWriter;

import java.util.Collection;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/3
 * @time: 上午10:48
 */
public class Test1 {
    public static void main(String[] args) {
        final int WEIGHT_INDEX = 0;
        // 定义车型
        VehicleTypeImpl.Builder vehicleTypeBuilder = VehicleTypeImpl.Builder.newInstance("vehicleType").addCapacityDimension(WEIGHT_INDEX, 2);
        VehicleType vehicleType = vehicleTypeBuilder.build();
        System.out.println(JSON.toJSONString(vehicleType));
        // 定义车辆
        VehicleImpl.Builder vehicleBuilder = VehicleImpl.Builder.newInstance("vehicle");
        vehicleBuilder.setStartLocation(Location.newInstance(10, 10));
        vehicleBuilder.setType(vehicleType);
        VehicleImpl vehicle = vehicleBuilder.build();
        System.out.println(JSON.toJSONString(vehicle));
        // 定义服务
        Service service1  = Service.Builder.newInstance("1").addSizeDimension(WEIGHT_INDEX, 1).setLocation(Location.newInstance(5, 7)).build();
        Service service2  = Service.Builder.newInstance("2").addSizeDimension(WEIGHT_INDEX, 1).setLocation(Location.newInstance(5, 13)).build();
        Service service3  = Service.Builder.newInstance("3").addSizeDimension(WEIGHT_INDEX, 1).setLocation(Location.newInstance(15, 7)).build();
        Service service4  = Service.Builder.newInstance("4").addSizeDimension(WEIGHT_INDEX, 1).setLocation(Location.newInstance(15, 13)).build();
        // 使用车辆和服务构建vrp模型
        VehicleRoutingProblem.Builder vrpBuilder = VehicleRoutingProblem.Builder.newInstance();
        vrpBuilder.addVehicle(vehicle);
        vrpBuilder.addJob(service1).addJob(service2).addJob(service3).addJob(service4);
        VehicleRoutingProblem problem = vrpBuilder.build();
        System.out.println("problem: "+JSON.toJSONString(problem));
        // 运行算法
        VehicleRoutingAlgorithm algorithm = Jsprit.createAlgorithm(problem);
        Collection<VehicleRoutingProblemSolution> solutions = algorithm.searchSolutions();
        System.out.println(JSON.toJSONString(solutions));
        VehicleRoutingProblemSolution bestSolution = Solutions.bestOf(solutions);
        System.out.println(JSON.toJSONString(bestSolution));
        SolutionPrinter.print(problem, bestSolution, SolutionPrinter.Print.CONCISE);
        SolutionPrinter.print(problem, bestSolution, SolutionPrinter.Print.VERBOSE);
        new VrpXMLWriter(problem, solutions).write("output/problem-with-solution.xml");
        new Plotter(problem, bestSolution).plot("output/solution.png", "solution");
        new GraphStreamViewer(problem, bestSolution).setRenderDelay(100).display();
    }
}

package com.wxh.datastructure.recursion;

/**
 * @description: 迷宫问题
 * 1. 1表示障碍物，0为可以通行，2为已经走过的格子，3为无法通行
 * @author: wuxinhong
 * @date: 2020/1/16
 * @time: 上午9:30
 */
public class Maze {
    public static final int SIZE = 8;
    int[][] maze = new int[SIZE][SIZE];

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.show();
    }
    public Maze(){
        for(int i=0; i<SIZE; i++){
            maze[0][i] = 1;
            maze[i][0] = 1;
            maze[SIZE-1][i] = 1;
            maze[i][SIZE-1] = 1;
        }
    }

    /**
     * 按下、右、左、上的顺序走迷宫
     * @param i
     * @param j
     */
    public void step(int i, int j){
        if(i==SIZE-1 && j==SIZE-1 && maze[i][j]==0){
            show();
            return;
        }
        maze[i][j] = 2;
        if(maze[i+1][j]==0){
            step(i+1, j);
        }
    }

    /**
     * 打印
     */
    public void show(){
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                System.out.print(maze[i][j]);
                System.out.printf(" ");
            }
            System.out.println();
        }
    }
}

/*
// File:             FoodController.java
// Created:          2018/06/19
// Author:           danIv (Daniel Ivanovich)
// Description:      The class that controls the spawning and collecting of food.
*/

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FoodController {
    private static ArrayList<Block> foodOnGrid;
    private Window game;
    private Grid grid;

    public FoodController(Window game, Grid grid) {
        this.game = game;
        this.grid = grid;
        this.foodOnGrid = new ArrayList<>();
    }

    public void collectFood(Snake snake, AudioManager audioManager) {
        Block head = snake.getHead();

        Block collectedFood = null;

        for (Block food : foodOnGrid) {
            if (head.getCellLocation(grid).containsBlock(food)) {
                collectedFood = food;
                break;
            }
        }

        if (collectedFood != null) {
            audioManager.playFoodCollectedSound();
            collectedFood.pickedUp(snake);
            foodOnGrid.remove(collectedFood);
        }
    }

    public int amountOfFoodOnGrid() {
        return foodOnGrid.size();
    }

    public void spawnFood(Snake snake) {
        Random gen = new Random();
        int amountOfFoodToSpawn = gen.nextInt(2) + 1;

        for (int i = 0; i < amountOfFoodToSpawn; i++) {
            ArrayList<Cell> openCells = getUnoccupiedCells(snake);
            if (openCells.size() != 0) {
                Block food = new Block(false, grid, null);
                int index = gen.nextInt(openCells.size());
                Cell chosen = openCells.get(index);
                food.moveToCell(chosen);
                foodOnGrid.add(food);
            }
        }
    }

    private ArrayList<Cell> getUnoccupiedCells(Snake snake) {
        Cell[][] columnArray = grid.getGrid();
        ArrayList<Block> snakeArray = snake.getBlocks();

        ArrayList<Cell> unoccupiedCells = new ArrayList<>();

        for (Cell[] column : columnArray) {
            for (Cell cell : column) {
                unoccupiedCells.add(cell);
            }
        }

        for (Block block : snakeArray) {
            for (Cell[] column : columnArray) {
                for (Cell cell : column) {
                    if (cell.containsBlock(block))
                        unoccupiedCells.remove(cell);
                }
            }
        }

        for (Block food : foodOnGrid) {
            for (Cell[] column : columnArray) {
                for (Cell cell : column) {
                    if (cell.containsBlock(food))
                        unoccupiedCells.remove(cell);
                }
            }
        }


        return unoccupiedCells;
    }

    public void drawFood(Graphics g) {
        for (Block food : foodOnGrid) {
            food.draw(g);
        }
    }
}

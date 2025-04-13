package tutorial10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Board {
    // Dimensions of the board
    int width, height;

    // Start and finish positions
    int startX = 0, startY = 0, finalX = 0, finalY = 0;

    // The possible moves a knight can make.
    final int[][] legalMoves = { { 1, 2 }, { 2, 1 }, { 1, -2 }, { 2, -1 }, { -1, 2 }, { -2, 1 }, { -1, -2 },
            { -2, -1 } };

    // Graph vertices. Each keeps track of where it was reached from.
    public class Vertex {
        public int posX, posY;
        public Vertex parent;

        public Vertex(int x, int y, Vertex p) {
            posX = x;
            posY = y;
            parent = p;
        }
    };

    // Keeps track of which squares have been visited, and stores the vertices.
    // This works as the closed list for bfs/dfs.
    boolean visited[][];

    // Creates a new vertex for a given square.
    // Private since it does not check if there already is one; that is done by
    // bfsMove/dfsMove.
    // Note the (y,x) coordinates: this is done to make printing the board row by
    // row easier if needed.
    private Vertex makeVertex(int x, int y, Vertex p) {
        Vertex v = new Vertex(x, y, p);
        visited[y][x] = true;
        return v;
    }

    // Sets up the board, initially filled with null pointers.
    // Note dimensions are [height][width] since we use [y][x] coordinates.
    public Board(int w, int h) {
        width = w;
        height = h;
        visited = new boolean[height][width];
    }

    public void setFinal(int x, int y) {
        finalX = x;
        finalY = y;
    }

    public void setStart(int x, int y) {
        startX = x;
        startY = y;
    }

    // Print a path to vertex v.
    // Follows the predecessor pointers to get a reversed version and uses a stack
    // to flip it.
    public void printPath(Vertex v) {
        Stack<Vertex> path = new Stack<>();
        while (v != null) {
            path.push(v);
            v = v.parent;
        }

        while (!path.isEmpty()) {
            Vertex step = path.pop();
            System.out.print("(" + step.posX + "," + step.posY + ") ");
            if (!path.isEmpty()) {
                System.out.print("-> ");
            }
        }
        System.out.println();
    }

    // Checks if the square (x,y) is within bounds and unvisited.
    public boolean available(int x, int y) {
        return ((x >= 0) && (y >= 0) && (x < width) && (y < height) && !visited[y][x]);
    }

    // If the move (dx,dy) is possible, creates and enqueues a vertex for the
    // destination
    // dx and dy are the horizontal/vertical difference of the move, e.g. (2,0)
    // would move 2 to the right.
    // Used by bfs.
    public void bfsMove(Vertex v, int dx, int dy, Queue<Vertex> q) {
        int newX = v.posX + dx; // Calculate new x position
        int newY = v.posY + dy; // Calculate new y position
        // Check if the new position is available (within bounds and unvisited)
        // If so, create a new vertex and add it to the queue
        if (available(newX, newY)) {
            q.add(makeVertex(newX, newY, v));
        }
    }

    // Breadth-first search. For each explored vertex, tries all possible knight's
    // moves (e.g. (1,2) or (-2,1))
    void bfs() {
        // Create a queue for BFS and add the starting vertex
        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = makeVertex(startX, startY, null); // Create the starting vertex
        queue.add(start); // Add the starting vertex to the queue

        while (!queue.isEmpty()) { // While there are vertices to explore
            Vertex currentVertex = queue.poll(); // Get the next vertex to explore

            // Check if we reached the final position
            if (currentVertex.posX == finalX && currentVertex.posY == finalY) {
                System.out.println("BFS Path: ");
                printPath(currentVertex); // Print the path to the final position
                return; // Exit after finding the path
            }

            // Try all possible knight's moves from the current vertex
            for (int[] move : legalMoves) {
                bfsMove(currentVertex, move[0], move[1], queue); // Attempt to move in each direction
            }
        }
        System.out.println("No path found using BFS."); // If no path is found, print a message
    }

    // If the move (dx,dy) is possible, creates and pushes a vertex for the
    // destination
    // dx and dy are the horizontal/vertical difference of the move, e.g. (2,0)
    // would move 2 to the right.
    // Used by dfs.
    public void dfsMove(Vertex v, int dx, int dy, Stack<Vertex> q) {
        int newX = v.posX + dx; // Calculate new x position
        int newY = v.posY + dy; // Calculate new y position

        // Check if the new position is available (within bounds and unvisited)
        if (available(newX, newY)) {
            q.push(makeVertex(newX, newY, v)); // Create a new vertex and add it to the stack
        }
    }

    // Depth-first search. For each explored vertex, tries all possible knight's
    // moves (e.g. (1,2) or (-2,1))
    void dfs() {
        // Create a stack for DFS and add the starting vertex
        Stack<Vertex> stack = new Stack<>();
        Vertex start = makeVertex(startX, startY, null); // Create the starting vertex
        stack.push(start); // Add the starting vertex to the stack

        while (!stack.isEmpty()) { // While there are vertices to explore
            Vertex currentVertex = stack.pop(); // Get the next vertex to explore

            // Check if we reached the final position
            if (currentVertex.posX == finalX && currentVertex.posY == finalY) {
                System.out.println("DFS Path: ");
                printPath(currentVertex); // Print the path to the final position
                return; // Exit after finding the path
            }

            // Try all possible knight's moves from the current vertex
            for (int[] move : legalMoves) {
                dfsMove(currentVertex, move[0], move[1], stack); // Attempt to move in each direction
            }
        }
        System.out.println("No path found using DFS."); // If no path is found, print a message
    }

    public static void main(String[] args) {
        Board board = new Board(8, 8);
        board.setStart(1, 1);
        board.setFinal(7, 6);

        System.out.println("Running DFS:");
        board.dfs();

        System.out.println("\nRunning BFS:");
        Board board2 = new Board(8, 8); // new board to reset visited
        board2.setStart(1, 1);
        board2.setFinal(7, 6);
        board2.bfs();
    }
}

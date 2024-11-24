
Dynamic Data Visualization Tool

This project implements a dynamic data visualization tool for trees and graphs, showcasing operations such as traversals, shortest path algorithms, and spanning tree algorithms. The tool is built using JavaFX and contains features for binary trees, AVL trees, and graphs.
Features

    Binary Tree Operations
        Insertion, deletion, and balancing for Binary and AVL Trees.
        Tree traversals: In-order, Pre-order, Post-order.

    Graph Operations
        Graph representation: Adjacency List and Adjacency Matrix.
        Traversals: BFS and DFS.
        Shortest path algorithms: Dijkstra's and Bellman-Ford.
        Minimum spanning tree algorithms: Prim’s and Kruskal’s.

    Visualization Tool
        Interactive UI for visualizing tree and graph structures.
        Perform operations dynamically through a graphical interface.

Requirements

    Java Development Kit (JDK) 17 or higher.
    JavaFX SDK (Ensure JavaFX is installed and properly configured).
    A text editor or IDE like IntelliJ IDEA, Eclipse, or VS Code.

File Structure

/src
│── BinaryTree.java             // Binary tree and AVL tree implementation
│── Graph.java                  // Graph representation and algorithms
│── VisualizationTool.java      // JavaFX application for the visualization tool
│── VisualizationTool_Output.txt // Sample outputs
README.md                       // Project instructions

Setup Instructions
1. Install JavaFX

    Download the JavaFX SDK from JavaFX Official Site.
    Extract the SDK and note the path to the lib folder.

2. Clone the Repository
 git clone https://github.com/Ashish5180/DSA-Labsheet6

Run the following command in your terminal:

git clone https://github.com/your-username/dynamic-data-visualization-tool.git
cd dynamic-data-visualization-tool

Compiling and Running the Code
1. Compile

Use the javac command with the JavaFX library:

javac --module-path <path-to-javafx-lib> --add-modules javafx.controls,javafx.fxml src/*.java

Replace <path-to-javafx-lib> with the absolute path to the lib folder in your JavaFX SDK.
2. Run

Run the compiled program using the java command:

java --module-path <path-to-javafx-lib> --add-modules javafx.controls,javafx.fxml src/VisualizationTool

Test Cases

The program handles the following operations:

    Binary Tree Traversals: Insert, Delete, In-order, Pre-order, Post-order.
    Graph Traversals: BFS, DFS.
    Shortest Path Algorithms: Dijkstra’s, Bellman-Ford.
    Spanning Trees: Prim’s, Kruskal’s.

Sample outputs can be found in VisualizationTool_Output.txt.
Known Issues

    Ensure JavaFX is properly set up to avoid NoClassDefFoundError.
    If using an IDE, configure the JavaFX library in the project settings.

Contributing

    Fork the repository.
    Create a new branch (git checkout -b feature/your-feature).
    Commit your changes (git commit -am 'Add some feature').
    Push the branch (git push origin feature/your-feature).
    Open a pull request.

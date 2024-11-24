import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VisualizationTool extends Application {
    BinaryTree binaryTree = new BinaryTree();
    Graph graph = new Graph();

    @Override
    public void start(Stage stage) {
        // Main Layout
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        // Label
        Label label = new Label("Dynamic Data Visualization Tool");
        label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        root.getChildren().add(label);

        // TabPane for Binary Tree and Graph
        TabPane tabPane = new TabPane();

        // Binary Tree Tab
        Tab treeTab = new Tab("Binary Tree");
        treeTab.setContent(createBinaryTreeTab());
        treeTab.setClosable(false);

        // Graph Tab
        Tab graphTab = new Tab("Graph");
        graphTab.setContent(createGraphTab());
        graphTab.setClosable(false);

        tabPane.getTabs().addAll(treeTab, graphTab);
        root.getChildren().add(tabPane);

        // Scene Setup
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Data Visualization Tool");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createBinaryTreeTab() {
        VBox treeBox = new VBox();
        treeBox.setPadding(new Insets(10));
        treeBox.setSpacing(10);

        // Input for node
        TextField inputField = new TextField();
        inputField.setPromptText("Enter a value");

        // Buttons
        Button insertButton = new Button("Insert");
        Button deleteButton = new Button("Delete");
        Button inOrderButton = new Button("In-Order Traversal");
        Button preOrderButton = new Button("Pre-Order Traversal");
        Button postOrderButton = new Button("Post-Order Traversal");

        // Result Area
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setPrefHeight(200);

        // Event Handlers
        insertButton.setOnAction(e -> {
            int value = Integer.parseInt(inputField.getText());
            binaryTree.insert(value);
            resultArea.appendText("Inserted: " + value + "\n");
        });

        deleteButton.setOnAction(e -> {
            int value = Integer.parseInt(inputField.getText());
            binaryTree.delete(value);
            resultArea.appendText("Deleted: " + value + "\n");
        });

        inOrderButton.setOnAction(e -> resultArea.appendText("In-Order: " + binaryTree.inOrderTraversal() + "\n"));
        preOrderButton.setOnAction(e -> resultArea.appendText("Pre-Order: " + binaryTree.preOrderTraversal() + "\n"));
        postOrderButton.setOnAction(e -> resultArea.appendText("Post-Order: " + binaryTree.postOrderTraversal() + "\n"));

        // Add Components
        treeBox.getChildren().addAll(
                new Label("Binary Tree Operations"),
                inputField,
                new HBox(10, insertButton, deleteButton),
                new HBox(10, inOrderButton, preOrderButton, postOrderButton),
                resultArea
        );

        return treeBox;
    }

    private VBox createGraphTab() {
        VBox graphBox = new VBox();
        graphBox.setPadding(new Insets(10));
        graphBox.setSpacing(10);

        // Input Fields
        TextField nodeField = new TextField();
        nodeField.setPromptText("Enter Node");

        TextField edgeStartField = new TextField();
        edgeStartField.setPromptText("Start Node");
        TextField edgeEndField = new TextField();
        edgeEndField.setPromptText("End Node");
        TextField weightField = new TextField();
        weightField.setPromptText("Weight (Optional)");

        // Buttons
        Button addNodeButton = new Button("Add Node");
        Button addEdgeButton = new Button("Add Edge");
        Button bfsButton = new Button("BFS");
        Button dfsButton = new Button("DFS");

        // Result Area
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setPrefHeight(200);

        // Event Handlers
        addNodeButton.setOnAction(e -> {
            String node = nodeField.getText();
            graph.addNode(node);
            resultArea.appendText("Node Added: " + node + "\n");
        });

        addEdgeButton.setOnAction(e -> {
            String start = edgeStartField.getText();
            String end = edgeEndField.getText();
            int weight = weightField.getText().isEmpty() ? 1 : Integer.parseInt(weightField.getText());
            graph.addEdge(start, end, weight);
            resultArea.appendText("Edge Added: " + start + " -> " + end + " (Weight: " + weight + ")\n");
        });

        bfsButton.setOnAction(e -> resultArea.appendText("BFS: " + graph.bfs() + "\n"));
        dfsButton.setOnAction(e -> resultArea.appendText("DFS: " + graph.dfs() + "\n"));

        // Add Components
        graphBox.getChildren().addAll(
                new Label("Graph Operations"),
                new HBox(10, nodeField, addNodeButton),
                new HBox(10, edgeStartField, edgeEndField, weightField, addEdgeButton),
                new HBox(10, bfsButton, dfsButton),
                resultArea
        );

        return graphBox;
    }

    public static void main(String[] args) {
        launch();
    }
}

// Add placeholder classes for BinaryTree and Graph
class BinaryTree {
    public void insert(int value) {
        // Placeholder implementation
    }

    public void delete(int value) {
        // Placeholder implementation
    }

    public String inOrderTraversal() {
        return "Placeholder In-Order";
    }

    public String preOrderTraversal() {
        return "Placeholder Pre-Order";
    }

    public String postOrderTraversal() {
        return "Placeholder Post-Order";
    }
}

class Graph {
    public void addNode(String node) {
        // Placeholder implementation
    }

    public void addEdge(String start, String end, int weight) {
        // Placeholder implementation
    }

    public String bfs() {
        return "Placeholder BFS";
    }

    public String dfs() {
        return "Placeholder DFS";
    }
}

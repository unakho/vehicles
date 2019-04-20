
package nodes;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node{

    int id;
    int parentID;
    String label;

    /* grids is a 3-D String array that holds five different 2-D String arrays, which represent the playing field:
grids[0] holds an empty grid. Empty squares are represented byt the caret symbole, "^"
grids[1] through grids[4] hold preset playing fields where ships are reprented by "A" */
    private String grids[][][] =
            {
                    {
                            {"^","^","^","^","^"},
                            {"^","^","^","^","^"},
                            {"^","^","^","^","^"},
                            {"^","^","^","^","^"},
                            {"^","^","^","^","^"},
                    },{
                    {"A","^","^","^","A"},
                    {"^","^","^","^","^"},
                    {"^","^","^","^","^"},
                    {"^","^","^","^","^"},
                    {"A","^","^","^","A"},
            },{
                    {"A","^","^","^","^"},
                    {"^","A","^","^","^"},
                    {"^","^","A","^","^"},
                    {"^","^","^","A","^"},
                    {"^","^","^","^","A"},
            },{
                    {"^","^","^","^","^"},
                    {"^","^","A","^","^"},
                    {"^","A","A","A","^"},
                    {"A","^","A","^","A"},
                    {"^","^","A","^","^"},
            },{
                    {"^","^","^","^","^"},
                    {"^","A","A","A","^"},
                    {"^","A","A","A","^"},
                    {"^","A","A","A","^"},
                    {"^","^","^","^","^"},
            }
            };

    /* Declare two 2-D String Arrays.
       1. playerGrid contains the array the the player can see. It starts as an empty grid, and is updated based
          on the player's decisions.
       2. enemyGrid contains the preset playing field, populated with ships. */
    private String playerGrid[][];
    private String enemyGrid[][];

    public Node() {
    }

    public Node(int id, String label, int parentID) {
        setId(id);
        setParentID(parentID);
        setLabel(label);
    }

    public static void main(String[] args) throws IOException{

        List<Node> nodes = new ArrayList();
        nodes.add(new Node(123, "NodeB", 7000));
        nodes.add(new Node(7000, "NodeA", 0));
        nodes.add(new Node(9, "NodeC", 123));
        nodes.add(new Node(3, "NodeF", 0));
        nodes.add(new Node(25, "NodeE", 7000));
        nodes.add(new Node(2, "NodeD", 7000));
        nodes.add(new Node(10, "NodeG", 3));

        //new Node().printTree((ArrayList)nodes);
        //copyCharacters();
        //copyBytes();
        //printWriter();
        new Node().checkGrid();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label +" "+id + " "+ parentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getId() == node.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    void printTree(ArrayList<Node> nodes) {

        //create list nodes based on their levels
        List<Node> zeros = new ArrayList<>();
        List<Node> subNodes = new ArrayList<>();
        List<Node> subSubNodes = new ArrayList<>();

        //create the first level nodes
        for (Node node: nodes){
            if (node.getParentID() == 0)
                zeros.add(node);
        }

        //create the second level nodes
        for (Node node: zeros){
            subNodes.add(node);
            for (Node nestedNode : nodes) {
                if (node.getId() == nestedNode.getParentID()) {
                    subNodes.add(nestedNode);
                }
            }
        }

        //create the third level nodes
        for (Node node: subNodes){
            subSubNodes.add(node);
            for (Node nestedNode : nodes) {
                if (node.getId() == nestedNode.getParentID() && !subNodes.contains(nestedNode)) {
                    subSubNodes.add(nestedNode);
                }
            }
        }

        //print nodes using their common parent id
        System.out.println();
        for (Node node: subSubNodes){

            if (node.getParentID() == 0)
                System.out.print("");
            else if (node.getParentID() == 7000 || node.getParentID() == 3)
                System.out.print("\t");
            else if (node.getParentID() == 123) {
                for (int j = 0; j < 2; j++) {
                    System.out.print("\t");
                }
            }
            System.out.println(node);
        }
    }

    private static void copyBytes()throws IOException {
        Files.createDirectory(FileSystems.getDefault().getPath("/ukama/../field"));

        try(InputStream in = new BufferedInputStream(new FileInputStream
                ("C:/Users/ukama/Documents/general/send_data.txt"));
            OutputStream out = new BufferedOutputStream(new FileOutputStream
                    ("C:/Users/ukama/Documents/general/get_data.txt"))){

            int b;
            byte[] bytes = new byte[1024];
            while ((b = in.read(bytes)) != -1){
                out.write(bytes, 0, b);
                out.flush();
            }
        }
    }

    private static void copyCharacters()throws IOException{
        try(BufferedReader in = new BufferedReader(new FileReader(
                ("C:\\Users\\ukama\\Documents\\general\\send_data.txt")));
            BufferedWriter out = new BufferedWriter(new FileWriter(
                    "C:\\Users\\ukama\\Documents\\general\\get_data.txt"))){

            String s;
            while ((s = in.readLine()) != null){
                out.write(s);
            }
        }
    }

    private static void printWriter()throws IOException{
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
                    "C:\\Users\\ukama\\Documents\\general\\get_data.txt")))){

           out.print("This is ");
           out.println("xxx");
           out.printf("zzz");
           out.println();
           out.format("zzz");
           out.println();
           out.print("This is last line");
        }
    }
/*
    *//* This method initializes instances of the two grids. It takes in an integer arguments that picks one of
    the playing fileds in grids, based player's decisions *//*
    public Grid(int seed){

        //initializes playerGrid instance
        this.playerGrid = grids[0];
        // initializes enemyGrid instance
        this.enemyGrid = grids[seed];

        //tells the player how many ships are on the playing field
        if (seed == 1){
            System.out.println("Four ships spotted");
        }else if (seed == 2){
            System.out.println("Five ships spotted");
        }else if (seed == 3){
            System.out.println("Eight ships spotted");
        }else if (seed == 4){
            System.out.println("Nine ships spotted");
        }
    }*/

    /* this method prints the player grid only. It takes no arguments, hiding the enemy grid from the user.*/
    public void printGrid(){
        for (int row = 0; row < 5; row ++){
            for(int col =0; col < 5; col ++){
                System.out.print(playerGrid[row][col]);
            }
            System.out.println();
        }
    }
    /* This method handles the game's core mechanic. It takes in two integers that represents the coordinates "XY"
       picked by the player, where X and Y are integers corresponding to the rows and columns of the game grid.
       If the coordinates correspond to a square containing a ship ("A") then the string is replaced by an "X".
       If the coordinate correspond to an empty square ("^"), them then the string is replaced by an "0".
       Note that this method returns, and does not print.*/
    public String fire(int row, int col){
        if (enemyGrid[row][col] == "^"){
            playerGrid[row][col] = "O";
            enemyGrid[row][col] = "O";
            return "MISS";
        }
        else if (enemyGrid[row][col] == "A"){
            playerGrid[row][col] = "X";
            enemyGrid[row][col] = "X";
            return "HIT";
        }
        // if the square has already been checked.
        else return "Already tried";
    }

    public boolean checkGrid(){
		/* You must complete this method!
		   It must search the grid  for remaining ships. It must return 'true' if there are,
		   and 'false' if there are not. */
        for(int i = 0; i < grids.length; i++){
            for(int j = 0; j < grids[i].length; j++){
                for(int k = 0; k < grids[i][j].length; k++){
                    if (grids[i][j][k].equals("A"))
                        return true;
                }
            }
        }
        return false;
    }
}

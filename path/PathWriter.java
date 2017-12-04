
package path;

import algorithms.*;
import map.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class PathWriter {
    
    BufferedWriter fout;
    
    public PathWriter(String filePath) throws IOException{
        fout=new BufferedWriter(new FileWriter(filePath));
    }
    
    public void writePath(Stack<Node> path, double cost) throws IOException{
        fout.write(String.valueOf(cost));
        fout.newLine();
        while(!path.isEmpty()) {
            Node n = path.pop();
            fout.write("("+(n.y+1)+","+(n.x+1)+")");
            fout.newLine();
        }
        fout.close();
    }
    
    
    public void metaMapPrint(Node[][] map, Stack<Node> path){
        
    }
}

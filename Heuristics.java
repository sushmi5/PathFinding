
package algorithms;

import map.MapParser;

public class Heuristics {
    
    double straightLine(Node s1, Node s2){
        return Math.sqrt(Math.pow((s1.x-s2.x), 2)+Math.pow((s1.y-s2.y), 2));
    }
    
    double manhattan(Node s1, Node s2){
        return (Math.abs(s1.x-s2.x)+Math.abs(s1.y-s2.y));
    }
    
    double diagonal(Node s1, Node s2){
        double diag = Math.min(Math.abs(s1.x-s2.x), Math.abs(s1.y-s2.y))*Math.sqrt(2);
        double straight = Math.abs(Math.abs(s1.x-s2.x) - Math.abs(s1.y-s2.y)); 
        return diag+straight;
    }
    
    
    double heuristicZero(){
        return 0;
    }
    
    double heuristicOne(Node s1, Node s2){
        return Math.sqrt(Math.pow((s1.x-s2.x), 2)+Math.pow((s1.y-s2.y), 2))*0.25;
    }
    
    double heuristicTwo(Node s1, Node s2){
        return (Math.abs(s1.x-s2.x)+Math.abs(s1.y-s2.y))*0.25;
    }
    
    double heuristicThree(Node s1, Node s2){
        return Math.sqrt(Math.pow((s1.x-s2.x), 2) + Math.pow((s1.y-s2.y), 2));
    }
    
    double heuristicFour(Node s1, Node s2){
        double diag = Math.min(Math.abs(s1.x-s2.x), Math.abs(s1.y-s2.y))*Math.sqrt(2);
        double straight = Math.abs(Math.abs(s1.x-s2.x) - Math.abs(s1.y-s2.y)); 
        return diag+straight;
    }
    
    double heuristicFive(Node s1, Node s2){
        return manhattan(s1, s2);
    }
    
    double heuristicSix(Node s1, Node s2){
        double d1 = diagonal(s1, s2);
        double d2 = manhattan(s1, s2);
        double d3 = straightLine(s1, s2);
        return (d1+d2+d3)/3;
    }
    
}

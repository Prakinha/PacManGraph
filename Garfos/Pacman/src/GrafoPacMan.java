import java.util.*;   
class Graph<T>   
{   

private Map<T, List<T> > map = new HashMap<>();    
public void addNewVertex(T s){   
map.put(s, new LinkedList<T>());  
}   

 
public void addNewEdge(T source, T destination, boolean bidirectional){   
    if (!map.containsKey(source))   
    addNewVertex(source);   
    if (!map.containsKey(destination))   
    addNewVertex(destination);   
    map.get(source).add(destination);   
    if (bidirectional == true)   
    {   
    map.get(destination).add(source);   
    }   
}   


public void countVertices(){   
System.out.println("Numero de vertices: "+ map.keySet().size());   
}   



public void countEdges(boolean bidirection){        
    int count = 0;   
    for (T v : map.keySet())   
    {   
    count = count + map.get(v).size();   
    }   
    if (bidirection == true)   
    {   
    count = count / 2;   
    }   
    System.out.println("Numero de arestas: "+ count);   
}   


public void containsVertex(T s){   
if (map.containsKey(s))   
{   
System.out.println("Grafo contem"+ s + " como vertice.");   
}   
else   
{   
System.out.println("Grafo nao contem "+ s + " como vertice.");   
}   
}   

 
public void containsEdge(T s, T d){   
    if (map.get(s).contains(d))   
    {   
    System.out.println("Grafo possui uma aresta entre "+ s + " e " + d + ".");   
    }   
    else   
    {   
    System.out.println("Grafo nao possui uma aresta entre "+ s + " e " + d + ".");   
}   
}   




@Override  
public String toString(){   
    StringBuilder builder = new StringBuilder();   
    for (T v : map.keySet()){   
        builder.append(v.toString() + ": ");   
        for (T w : map.get(v)){   
            builder.append(w.toString() + " ");   
            }   
        builder.append("\n");   
    }   
    return (builder.toString());   
}   



public void BFS(T source, T target){
if(map.containsKey(source) & map.containsKey(target)){
    boolean found = false; 
    for (T v : map.keySet()){   
        for (T w : map.get(v)){   
            if(w == target || found){
            return;
             } else BFS(w, target);
        }   
}
}
}}


public class GrafoPacMan{   
    @SuppressWarnings("unchecked")
    public static void main(String args[])   
    {    
        @SuppressWarnings("rawtypes")
        Graph graph=new Graph();   
        graph.addNewEdge(1, 2, true);   
        graph.addNewEdge(1, 6, true);   
        graph.addNewEdge(2, 3, true);   
        graph.addNewEdge(2, 5, false);   
        graph.addNewEdge(3, 4, true);   
        graph.addNewEdge(3, 5, true);   
        graph.addNewEdge(4, 9, true);   
        graph.addNewEdge(5, 7, true);   
        graph.addNewEdge(5, 8, true);   
        graph.addNewEdge(7, 6, true); 
        graph.addNewEdge(8, 9, true); 
        graph.addNewEdge(6, 11, true); 
        graph.addNewEdge(6, 13, true); 
        graph.addNewEdge(11, 13, true); 
        graph.addNewEdge(7, 11, true); 
        graph.addNewEdge(7, 10, true); 
        graph.addNewEdge(10, 11, true); 
        graph.addNewEdge(11, 14, true); 
        graph.addNewEdge(13, 14, true); 
        graph.addNewEdge(10, 8, true); 
        graph.addNewEdge(10, 12, true); 
        graph.addNewEdge(8, 12, true); 
        graph.addNewEdge(12, 9, true); 
        graph.addNewEdge(12, 16, true); 
        graph.addNewEdge(12, 15, true); 
        graph.addNewEdge(9, 16, true); 
        graph.addNewEdge(14, 15, true); 
        graph.addNewEdge(15, 16, true); 




        System.out.println("Lista de Adjacencia:\n"+ graph.toString());  

    }   
}  
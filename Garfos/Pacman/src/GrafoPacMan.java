import java.util.*;

class Graph<T> {
    private Map<T, List<T>> map = new HashMap<>();

    public void addNewVertex(T s) {
        map.put(s, new LinkedList<T>());
    }

    public void addNewEdge(T source, T destination, boolean bidirectional) {
        if (!map.containsKey(source))
            addNewVertex(source);
        if (!map.containsKey(destination))
            addNewVertex(destination);
        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }
    

    public void countVertices() {
        System.out.println("Número de vértices: " + map.keySet().size());
    }

    public void countEdges(boolean bidirectional) {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirectional) {
            count /= 2;
        }
        System.out.println("Número de arestas: " + count);
    }

    public void containsVertex(T s) {
        if (map.containsKey(s)) {
            System.out.println("Grafo contém " + s + " como vértice.");
        } else {
            System.out.println("Grafo não contém " + s + " como vértice.");
        }
    }

    public void containsEdge(T s, T d) {
        if (map.get(s).contains(d)) {
            System.out.println("Grafo possui uma aresta entre " + s + " e " + d + ".");
        } else {
            System.out.println("Grafo não possui uma aresta entre " + s + " e " + d + ".");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    // Método BFS implementado corretamente
    public void BFS(T source, T target) {
        if (!map.containsKey(source) || !map.containsKey(target)) {
            System.out.println("Vértice de origem ou destino não existe.");
            return;
        }

        Set<T> visited = new HashSet<>(); // Para acompanhar os visitados
        Queue<T> queue = new LinkedList<>(); // Fila para BFS
        Map<T, T> parent = new HashMap<>(); // Para reconstruir o caminho

        visited.add(source);
        queue.add(source);
        parent.put(source, null);

        while (!queue.isEmpty()) {
            T current = queue.poll();

            if (current.equals(target)) {
                System.out.println("Caminho encontrado até o alvo: " + reconstructPath(parent, target));
                return;
            }

            for (T neighbor : map.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    parent.put(neighbor, current); // Guarda o pai do vizinho
                }
            }
        }

        System.out.println("Alvo não encontrado no grafo.");
    }

    // Método auxiliar para reconstruir o caminho do alvo até a origem
    private List<T> reconstructPath(Map<T, T> parent, T target) {
        List<T> path = new LinkedList<>();
        for (T at = target; at != null; at = parent.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}

public class GrafoPacMan {
    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        @SuppressWarnings("rawtypes")
        Graph graph = new Graph();
        graph.addNewEdge(1, 2, true);
        graph.addNewEdge(1, 6, true);
        graph.addNewEdge(2, 3, true);
        graph.addNewEdge(2, 5, true);
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

        System.out.println("Lista de Adjacência:\n" + graph.toString());

        System.out.println("Executando BFS:");
        for (int i = 1; i <= 16; i++) {
            graph.BFS(i, 16);
        }
        // graph.BFS(5, 16); // Exemplo de BFS de 1 até 16
    }
}
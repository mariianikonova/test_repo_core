package algorithms.tree;

/**
 * Created by user on 06.03.15.
 */
public class BFS {
    public static void main(String[] args) {

    }


    int peaksAmount;
    Boolean[] used = new Boolean[peaksAmount];
    Node[] queue = new Node[peaksAmount];
    int qH = 0; //queue pick
    int qT = 0; //queue tail

/*    void bfsIterative(Node node) {
        //put first peak;
        used[node.getIndex()] = true;
        queue[qT++] = node;
        Node[][] graph;
        while (qH < qT) {
            node = queue[qH++];
            for (int i = 0; i < peaksAmount; i++) {
                if (!used[node.getIndex()] && node.getLeftNode().getIndex() ||) {
                    used[i] = true;
                    queue[qT++] = i;
                }
            }
        }

        System.out.println("Passed: " + node.getIndex());
    }*/

/*    void justBFS(int v) {
        boolean[] used = new boolean[vNum]; // массив пометок
        int[] queue = new int[vNum]; // очередь
        int qH = 0; // голова очереди
        int qT = 0; // хвост
               *//* <обработка вершины v> *//*
        used[v] = true; // помечаем исходную вершину
        queue[qT++] = v; // помещаем ее в очередь
        while (qH < qT) { // пока очередь не пуста
            v = queue[qH++]; // извлекаем текущую вершину
            for (int nv = 0; nv < vNum; nv++) { // перебираем вершины
                if (!used[nv] && graph[v][nv]) { // если nv не помечена и смежна с v
                                   *//* <обработка вершины nv> *//*
                    used[nv] = true; // помечаем ее
                    queue[qT++] = nv; // и добавляем в очередь
                }
            }
        }
    }
}*/
}

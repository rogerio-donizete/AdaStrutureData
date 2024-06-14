package problemsSolving;

/* Dado um inetiro k e um afila de inteiros, a tarefa é
inverter a ordem dos primeiros k elementos da fila,
deixando os demais na emsma orde relativa.

exemplo1: [1,2,3,4,5] -> k =2 -> [2,1,3,4,5]
exemplo2: [1,2,3,4,5] -> k =4 -> [4,3,2,1,5]
 */

import java.util.LinkedList;
import java.util.Queue;

public class problemTwo {

    public static Queue<Integer> reverseFirstK(Queue<Integer> queue, int k){
        solveQueue(queue, k);
        int n = queue.size() - k;
        while (n-- > 0){
            int element = queue.remove();
            queue.add(element);
            }
        return queue;
        }

    private static void solveQueue(final Queue<Integer> queue, final int k) {
        if(k==0) return;
        int element = queue.remove();
        solveQueue(queue, k-1);queue.add(element);

    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        System.out.println(reverseFirstK(queue, 3));
    }

}

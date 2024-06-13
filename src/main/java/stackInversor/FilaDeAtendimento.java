package stackInversor;

import structureData.Queue;

import java.util.Random;

public class FilaDeAtendimento {

    public static void main(String[] args) {
        int n = 5;
        var random = new Random();
        int cliente = random.nextInt(101);
        Queue queue = new Queue(cliente);
        System.out.println("Chegou o cliente: " + cliente);
    //simula a chega dos clientes
        for (int i=2;i<=n; i++){
            cliente = random.nextInt(101);
            queue.enqueue(cliente);
            System.out.println("Chegou o cliente: " + cliente);
        }

        //Atendiemnto dos clietes

        var node = queue.dequeue();
        while (node != null){
            System.out.println("Atendido cliente: " + node.getValue());
            node = queue.dequeue();
        }
    }

}

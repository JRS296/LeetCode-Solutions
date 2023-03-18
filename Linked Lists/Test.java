//Netcom DA 4

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 4 blocks of IP address one by one");
        int ip[] = new int[4];
        for (int i = 0; i < 4; i++) {
            ip[i] = sc.nextInt();
        }
        System.out.println("Enter IP mask");
        int m = sc.nextInt();
        System.out.println("How many groups will the address be divided in? ");
        int n = sc.nextInt();
        int c[] = new int[n];
        int a[] = new int[n];
        int pl[] = new int[n];
        int fa3[] = new int[n];
        int fa4[] = new int[n];
        int la3[] = new int[n];
        int la4[] = new int[n];
        int t[] = new int[n];
        int sum = 0, p = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number of customers for group: "
                    + (i + 1) + " ");
            c[i] = sc.nextInt();
            System.out.println("Enter number of addresses for group: " + (i + 1) + " ");
            a[i] = sc.nextInt();
        }
        int x = 0;
        if (ip[0] > 0 && ip[0] < 128) {
            System.out.println("Class A IP Address");
        }
        if (ip[0] > 127 && ip[0] < 192) {
            System.out.println("Class B IP Address");
        }
        if (ip[0] > 191 && ip[0] < 223) {
            System.out.println("Class C IP Address");
        }
        for (int i = 0; i < n; i++) {
            pl[i] = 32 - (int) (Math.log(a[i]) / Math.log(2));
            fa3[i] = p;
            x = c[i] / (256 / a[i]);
            la3[i] = fa3[i] + x - 1;
            p = la3[i] + 1;
            fa4[i] = 0;
            la4[i] = 255;
            t[i] = c[i] * a[i];
            sum += t[i];
            System.out.println("First Address of group " + (i + 1) + " is: " + ip[0] + "." + ip[1] + "." + fa3[i] + "."
                    + fa4[i] + "/" + pl[i]);
            System.out.println("Last Address of group " + (i + 1) + " is: " + ip[0] + "." + ip[1] + "." + la3[i] + "."
                    + la4[i] + "/" + pl[i]);
            System.out.println("Number of addresses in group " + (i + 1) + "is: " + t[i]);
        }
        System.out.println("Number of available addresses: " + (65536 - sum));
    }
}

//import java.io.*;

public class DVR {
    static int graph[][];
    static int via[][];
    static int rt[][];
    static int v;
    static int e;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter the number of Vertices: ");
        v = Integer.parseInt(br.readLine());

        System.out.println("Please enter the number of Edges: ");
        e = Integer.parseInt(br.readLine());

        graph = new int[v][v];
        via = new int[v][v];
        rt = new int[v][v];
        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++) {
                if (i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = 9999;
            }

        for (int i = 0; i < e; i++) {
            System.out.println("Please enter data for Edge " + (i + 1) + ":");
            System.out.print("Source: ");
            int s = Integer.parseInt(br.readLine());
            s--;
            System.out.print("Destination: ");
            int d = Integer.parseInt(br.readLine());
            d--;
            System.out.print("Cost: ");
            int c = Integer.parseInt(br.readLine());
            graph[s][d] = c;
            graph[d][s] = c;
        }

        dvr_calc_disp("The initial Routing Tables are: ");

        System.out.print("Please enter the Source Node for the edge whose cost has changed: ");
        int s = Integer.parseInt(br.readLine());
        s--;
        System.out.print("Please enter the Destination Node for the edge whose cost has changed: ");
        int d = Integer.parseInt(br.readLine());
        d--;
        System.out.print("Please enter the new cost: ");
        int c = Integer.parseInt(br.readLine());
        graph[s][d] = c;
        graph[d][s] = c;

        dvr_calc_disp("The new Routing Tables are: ");
    }

    static void dvr_calc_disp(String message) {
        System.out.println();
        init_tables();
        update_tables();
        System.out.println(message);
        print_tables();
        System.out.println();
    }

    static void update_table(int source) {
        for (int i = 0; i < v; i++) {
            if (graph[source][i] != 9999) {
                int dist = graph[source][i];
                for (int j = 0; j < v; j++) {
                    int inter_dist = rt[i][j];
                    if (via[i][j] == source)
                        inter_dist = 9999;
                    if (dist + inter_dist < rt[source][j]) {
                        rt[source][j] = dist + inter_dist;
                        via[source][j] = i;
                    }
                }
            }
        }
    }

    static void update_tables() {
        int k = 0;
        for (int i = 0; i < 4 * v; i++) {
            update_table(k);
            k++;
            if (k == v)
                k = 0;
        }
    }

    static void init_tables() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i == j) {
                    rt[i][j] = 0;
                    via[i][j] = i;
                } else {
                    rt[i][j] = 9999;
                    via[i][j] = 100;
                }
            }
        }
    }

    static void print_tables() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print("Dist: " + rt[i][j] + "    ");
            }
            System.out.println();
        }
    }

}
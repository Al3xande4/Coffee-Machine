import java.util.Scanner;
public class Program {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] ingridience = new int[]{400, 540, 120, 550, 9};
        int waterIndex = 0;
        int milkIndex = 1;
        int beansIndex = 2;
        int moneyIndex = 3;
        int cupIndex = 4;
        int[] espresso = new int[]{250, 0, 16, 4};
        int[] latte = new int[]{350, 75, 20, 7};
        int[] cappuchino = new int[]{200, 100, 12, 6};
        boolean working = true;

        while(working)
        {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = in.nextLine();
            if (action.equals("buy")) {
                ingridience = buy(ingridience, waterIndex, milkIndex, beansIndex, moneyIndex, cupIndex, espresso, latte, cappuchino);
            } else if (action.equals("fill")) {
                ingridience = fill(ingridience, waterIndex, milkIndex, beansIndex, cupIndex);
            }else if(action.equals("take")) {
                ingridience = take(ingridience, moneyIndex);
            } else if (action.equals("exit")){
                working = false;
            }else if(action.equals("remaining")){
                remaining(ingridience, waterIndex, milkIndex, beansIndex, cupIndex, moneyIndex);
            }
            else{
                System.out.println("Unknown action");
            }
        }
    }
    public static int[] buy(int[] ingridience,int waterIndex, int milkIndex, int beansIndex, int moneyIndex, int cupIndex,
                            int[] espresso, int[] latte, int[] cappuchino) {
        Scanner in = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back - to main menu: ");
        int kind = in.nextInt();
        switch (kind) {
            case 1:
                if (espresso[waterIndex] <= ingridience[waterIndex]) {
                    if (espresso[beansIndex] <= ingridience[beansIndex]){
                        System.out.println("I have enough resources, making you a coffee!");
                        ingridience[moneyIndex] += espresso[moneyIndex];
                        ingridience[milkIndex] -= espresso[milkIndex];
                        ingridience[waterIndex] -= espresso[waterIndex];
                        ingridience[beansIndex] -= espresso[beansIndex];
                        ingridience[cupIndex]--;
                    }
                    else{
                        System.out.println("Sorry, not enough beans!");
                    }
                }
                else{
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case 2:
                if (latte[waterIndex] <= ingridience[waterIndex]) {
                    if(latte[milkIndex] <= ingridience[milkIndex]){
                        if (latte[beansIndex] <= ingridience[beansIndex]){
                            System.out.println("I have enough resources, making you a coffee!");
                            ingridience[moneyIndex] += latte[moneyIndex];
                            ingridience[milkIndex] -= latte[milkIndex];
                            ingridience[waterIndex] -= latte[waterIndex];
                            ingridience[beansIndex] -= latte[beansIndex];
                            ingridience[cupIndex]--;
                        }
                        else{
                            System.out.println("Sorry, not enough beans!");
                        }
                    }
                    else{
                        System.out.println("Sorry, not enough milk!");
                    }
                }
                else{
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case 3:
                if (cappuchino[waterIndex] <= ingridience[waterIndex]) {
                    if(cappuchino[milkIndex] <= ingridience[milkIndex]){
                        if (cappuchino[beansIndex] <= ingridience[beansIndex]){
                            System.out.println("I have enough resources, making you a coffee!");
                            ingridience[moneyIndex] += cappuchino[moneyIndex];
                            ingridience[milkIndex] -= cappuchino[milkIndex];
                            ingridience[waterIndex] -= cappuchino[waterIndex];
                            ingridience[beansIndex] -= cappuchino[beansIndex];
                            ingridience[cupIndex]--;
                        }
                        else{
                            System.out.println("Sorry, not enough beans!");
                        }
                    }
                    else{
                        System.out.println("Sorry, not enough milk!");
                    }
                }
                else{
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case 4:
                return ingridience;
            default:
                System.out.println("Unknown coffee");
                break;
        }
        return ingridience;
    }
    public static int[] fill(int[] ingridience, int waterIndex, int milkIndex, int beansIndex, int cupIndex){
        Scanner in = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        ingridience[waterIndex] += in.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        ingridience[milkIndex] += in.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        ingridience[beansIndex] += in.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        ingridience[cupIndex] += in.nextInt();
        return ingridience;
    }
    public static int[] take(int[] ingridience, int moneyIndex){
        System.out.println("I gave you $" + ingridience[moneyIndex]);
        ingridience[moneyIndex] = 0;
        return ingridience;
    }
    public static void remaining(int[] ingridience, int waterIndex, int milkIndex, int beansIndex, int cupIndex, int moneyIndex){
        System.out.println("The coffee machine has:");
        System.out.println(ingridience[waterIndex] + " ml of water");
        System.out.println(ingridience[milkIndex] + " ml of milk");
        System.out.println(ingridience[beansIndex] + " g of coffee beans");
        System.out.println(ingridience[cupIndex] + " disposable cups");
        System.out.println("$ " + ingridience[moneyIndex] + " of money");
    }
}

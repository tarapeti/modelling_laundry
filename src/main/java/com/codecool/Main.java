package com.codecool;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMachineException {


        //some default clothes
        Cloth def1 = new Cloth(0, "t-shirt", Colors.ORANGE, State.DIRTY);
        Cloth def2 = new Cloth(1, "pants", Colors.BLACK, State.DIRTY);
        Cloth def3 = new Cloth(1, "hoodie", Colors.WHITE, State.DIRTY);

        Laundromat laundromat = new Laundromat();
        //kell még a ruhákat ide oda tenni -> updatelni a laundromat listáit
        //exceptionok ne őljék meg a prog
        //


        while (true) {
            System.out.println("LAUNDRY MODEL");

            //menu
            System.out.println("CREATE A CLOTH : 1");

            System.out.println("LIST ALL CLOTH : 2");

            System.out.println("CREATE A MACHINE : 3");

            System.out.println("USE THE MACHINE : 4");

            System.out.println("QUIT : 5");

            Scanner menuopti = new Scanner(System.in);

            int pick = Integer.valueOf(menuopti.nextLine());

            switch (pick) {
                case 1:
                    laundromat.addToAllCloth(createCloth());
                    break;
                case 2:
                    listCloth(laundromat.getAllCloth());
                    break;
                case 3:
                    System.out.println("ENTER THE TYPE (WASHING MACHINE OR DRYER)");
                    Scanner machineType = new Scanner(System.in);
                    String type = machineType.nextLine();
                    System.out.println("ENTER THE SIZE");
                    Scanner machineSize = new Scanner(System.in);
                    int size = Integer.valueOf(machineType.nextLine());//??
                    laundromat.addToMachines(HHAppliance.makeMachine(type, size));
                    break;
                case 4:
                    System.out.println("WHICH MACHINE DO YOU WANT TO USE?: ");
                    listMachines(laundromat.getMachines());

                    Scanner toUse = new Scanner(System.in);
                    int using = Integer.valueOf(toUse.nextLine());

                    HHAppliance appliance = laundromat.getMachines().get(using);

                    System.out.println("WHAT WOULD YOU LIKE TO DO? (ADD/PROGRAM)");
                    Scanner action = new Scanner(System.in);
                    String act = action.nextLine();
                    if (act.equals("add")) {
                        listCloth(laundromat.getAllCloth());
                        System.out.println("ENTER THE CLOTHS ID");
                        Scanner idScan = new Scanner(System.in);
                        int pickId = Integer.valueOf(idScan.nextLine());
                        try {
                            appliance.addtoMachine(laundromat.findCloth(laundromat.getAllCloth(), pickId));
                            System.out.println("Cloth succesfuly added");
                        } catch (Exception e) {
                            System.out.println("Please enter a correct id");

                        }

                    } else if (act.equals("program")) {
                        if (appliance.getInMachine().size() > 0) {
                            appliance.program();
                            //sleep
                            System.out.println("The program finished1");
                            break;
                        } else {
                            System.out.println("No clothes in the machine");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.exit(0);
            }

        }

    }


    //menuop
    private static Cloth createCloth() {
        System.out.println("NAME: ");
        Scanner nameScan = new Scanner(System.in);
        String name = nameScan.nextLine();

        System.out.println("COLOR: ");
        Scanner colorScan = new Scanner(System.in);
        String color = colorScan.nextLine();

        System.out.println("STATE: ");
        Scanner stateScan = new Scanner(System.in);
        String state = stateScan.nextLine();

        return Cloth.createCloth(name, color, state);
    }

    private static void listCloth(List<Cloth> allCloth) {
        for (int i = 0; i < allCloth.size(); i++) {
            System.out.println(allCloth.get(i).getId() + " " + allCloth.get(i));
        }
    }

    private static void listMachines(List<HHAppliance> m) {
        for (int i = 0; i < m.size(); i++) {
            System.out.println(i + " " + m.get(i));
        }
    }

    private int addtoMachineHelper(List<Cloth> fromWhere, String name) { //ha id alapjan addolunk akkor nem kell
        List<Cloth> sameNamedOnes = new ArrayList<Cloth>();
        for (Cloth c : fromWhere) {
            if (c.getName().equals(name)) {
                sameNamedOnes.add(c);
            }
        }
        if (sameNamedOnes.size() == 0) {
            System.out.println("no such cloth"); // exception?
        } else if (sameNamedOnes.size() == 1) {
            return sameNamedOnes.get(0).getId();
        } else {
            System.out.println("there are multiple cloths with the same name:");
            int counter = 0;
            for (Cloth c : sameNamedOnes) {
                System.out.println(++counter + "" + c);

            }
            System.out.println("which one would you like to pick?");
            Scanner multi = new Scanner(System.in);
            int pick = multi.nextInt();
            return sameNamedOnes.get(pick).getId();
        }
        return 0;
    }

}


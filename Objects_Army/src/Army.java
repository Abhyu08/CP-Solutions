import javax.print.Doc;

class Army {
    // 5 Unit, 3 Knight, 1 General, 1 Doctor.
    public static void createArmy() {
        // Implement this method
        Unit units1 = new Unit("unit1");
        Unit units2 = new Unit("unit2");
        Unit units3 = new Unit("unit3");
        Unit units4 = new Unit("unit4");
        Unit units5 = new Unit("unit5");

        Knight knights1 = new Knight("knight1");
        Knight knights2 = new Knight("knight2");
        Knight knights3 = new Knight("knight3");

        General gen = new General("gen1");
        Doctor doc = new  Doctor("doc1");
    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}
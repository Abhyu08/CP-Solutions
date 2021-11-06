
class Main {
   private  enum DayOfWeek  {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY }
    public static void main(String[] args) {

        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day);
        }
    }
}

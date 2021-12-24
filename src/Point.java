public class Point {

    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Point point, int dx, int dy){
        point.x += dx;
        point.y += dy;

    }

    /**1. Первый вариант решения проблемы с помощью synchronized:
    Делаем метод synchronized:
        public synchronized void move(int dx, int dy){
           x += dx;
           y += dy;
        }

       2. Блок synchronized:
     Добавляем новый объект lock.

     private static final Object lock = new Object();

     public void move(int dx, int dy){
         synchronized (lock) {
             x += dx;
             y += dy;
             }
         }

     3. Добавляем статику в метод и в объект lock:

     private static final Object lock = new Object();

         public static void move(Point point, int dx, int dy){
              synchronized (lock) {
              point.x += dx;
              point.y += dy;
              }
         }

     4. Добавляем статику и synchronized в метод:

         public static synchronized void move(Point point, int dx, int dy){
              point.x += dx;
              point.y += dy;

         }
     **/
}

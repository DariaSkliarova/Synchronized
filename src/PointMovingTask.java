public class PointMovingTask implements Runnable {

    public Point point;

    public PointMovingTask(Point point) {
        this.point = point;
    }

    @Override
    public void run() {
        point.move(point, 1, 1);
    }
}

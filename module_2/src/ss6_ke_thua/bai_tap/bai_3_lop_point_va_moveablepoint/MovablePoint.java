package ss6_ke_thua.bai_tap.bai_3_lop_point_va_moveablepoint;

public class MovablePoint extends Point{
    public float xSpeed=0.0f;
    public float ySpeed=0.0f;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MovablePoint(float x,float y,float xSpeed,float ySpeed){
        super(x,y);
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed(){
        float []array={xSpeed,ySpeed};
        return array;
    }

    @Override
    public String toString() {
        return "("+x+","+y+"),speed= "+"("+xSpeed+","+ySpeed+")";
    }
    public MovablePoint move(){
        x+=xSpeed;
        y+=ySpeed;
        return this;

    }
}

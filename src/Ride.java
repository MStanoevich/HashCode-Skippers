public class Ride {
    int start, end;
    int startPos[] = new int[2];
    int endPos[] = new int[2];

    public void setStart(int start){
        this.start = start;
    }

    public int getStart(){
        return this.start;
    }

    public void setEnd(int end){
        this.end = end;
    }

    public int getEnd(){
        return this.end;
    }

    public int distance(){
        return Math.abs(start - end);
    }

    public void setPos(){}

}

public class Ride {
    int startStep, endStep;
    int endPos[], startPos[];
    boolean ridden;
    boolean bonusAvail = false;

    public Ride(int startStep, int endStep, int startPos[], int endPos[]) {
        this.startStep = startStep;
        this.endStep = endStep;
        this.startPos = startPos;
        this.endPos = endPos;
        this.ridden = false;
    }

    public void setStartStep(int startStep){
        this.startStep = startStep;
    }

    public int getStartStep(){
        return this.startStep;
    }

    public void setEndStep(int endStep){
        this.endStep = endStep;
    }

    public int getEndStep(){
        return this.endStep;
    }

    public int distance(){
        return Math.abs(startStep - endStep);
    }

    public void setPos(int startX, int startY, int endX, int endY){
        startPos[0] = startX;
        startPos[1] = startY;
        endPos[0] = endX;
        endPos[1] = endY;
    }

    public boolean rideTaken(){
        return ridden;
    }

}

package model;

class SaucerStateAlive implements SaucerState {

    @Override
    public void goNextState(FlyingSaucer context) {
        context.setState(new SaucerStateDying());
        context.state = GameFigure.STATE_DYING;
    }
    
}

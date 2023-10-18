package AlexAzyavchikov.Components;

import AlexAzyavchikov.Mediator.Mediator;

public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}

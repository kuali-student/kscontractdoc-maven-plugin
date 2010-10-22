package org.kuali.student.lum.program.client.events;

import com.google.gwt.event.shared.GwtEvent;
import org.kuali.student.common.ui.client.mvc.Callback;

/**
 * @author Igor
 */
public class UpdateEvent extends GwtEvent<UpdateEventHandler> {

    public static Type<UpdateEventHandler> TYPE = new Type<UpdateEventHandler>();

    private Callback<Boolean> okCallback;

    public UpdateEvent() {
    }

    public UpdateEvent(Callback<Boolean> okCallback) {
        this.okCallback = okCallback;
    }

    @Override
    public Type<UpdateEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(UpdateEventHandler handler) {
        handler.onEvent(this);
    }

    public Callback<Boolean> getOkCallback() {
        return okCallback;
    }
}
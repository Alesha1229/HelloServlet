package by.alesha.helloservlet.Listeners;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class MyFirstListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Attribute added!!!");
        System.out.println("Event: " + event.getName() + " " + event.getValue());
        //HttpSessionAttributeListener.super.attributeAdded(event);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Attribute removed!!!");
        System.out.println("Event: " + event.getName() + " " + event.getValue());
        //HttpSessionAttributeListener.super.attributeRemoved(event);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Attribute replaced!!!");
        System.out.println("Event: " + event.getName() + " " + event.getValue());
        //HttpSessionAttributeListener.super.attributeReplaced(event);
    }
}

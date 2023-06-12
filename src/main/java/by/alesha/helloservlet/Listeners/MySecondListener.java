package by.alesha.helloservlet.Listeners;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

import javax.print.attribute.Attribute;
@WebListener
public class MySecondListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        ServletContextAttributeListener.super.attributeAdded(event);
        System.out.println("Context attribute added!!!");
        System.out.println("event: " + event.getName() + " " + event.getValue());
    }
}

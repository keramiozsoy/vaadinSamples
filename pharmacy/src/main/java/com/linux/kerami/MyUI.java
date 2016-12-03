package com.linux.kerami;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("mytheme")
@Widgetset("com.linux.kerami.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
//        final VerticalLayout layout = new VerticalLayout();
//        layout.setMargin(true);
//        setContent(layout);
//
//        Button button = new Button("Click Me");
//        Button button2 = new Button("Kenk");
//        button.addClickListener(new Button.ClickListener() {
//            @Override
//            public void buttonClick(ClickEvent event) {
//                layout.addComponent(new Label("Thank you for clicking kanak"));
//            }
//        });
//        layout.addComponent(button);
//        layout.addComponent(button2);
    	
    	 
    	Label label  = new Label(" Hello this is my application .....");

    	final TextField txtfield = new TextField("Enter something");
    	
    	Button button = new Button("First You should write and click");
    	button.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("The caption",
		                  "This is " + txtfield.getValue(),
		                  Notification.Type.ERROR_MESSAGE);
				
			}
		});
    	
    	VerticalLayout vl  = new VerticalLayout();
    	vl.setSpacing(true);
    	vl.setMargin(true);
    	vl.addComponent(label);
    	vl.addComponents(txtfield,button);
    	setContent(vl);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

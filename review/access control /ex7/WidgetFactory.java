class WidgetFactory {
    public static Widget createWidget(){
        System.out.println("Creating Widget through Factory");
        return new Widget();

    }
    public static void operateWidget(){
        Widget w = createWidget();
        w.display();

    }
}
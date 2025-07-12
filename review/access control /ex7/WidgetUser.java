public class WidgetUser {
    public static void main(String[] args){
        System.out.println("Testing Widget access from outside package");
        Object widget1 = WidgetFactory.createWidget();
        WidgetFactory.operateWidget();
        System.out.println("Widget test completed");

    }
    
}

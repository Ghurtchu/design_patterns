package traits_and_mixin_compositions.traits;

public class ExtendingClassesInJava {
    interface Connector {
        void connect();
        void close();
    }

    // interface can not extend abstract class
    // but it can extend interfaces
    // and override methods with the help of `default` keyword
    interface ConnectorWithHelper extends Connector {

        @Override
        default void connect() {
            System.out.println();
        }

        @Override
        default void close() {
            System.out.println();
        }
    }

}

module Train {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.base;
    requires javafx.base;

    opens ch.nahro.controller to javafx.fxml;
    opens ch.nahro.model to org.hibernate.orm.core, javafx.base;

    exports ch.nahro to javafx.graphics, javafx.fxml;
    exports ch.nahro.controller to javafx.fxml;
}
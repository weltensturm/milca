
Apache Pivot Doku
===

Button Event Handler
---

In App.initialize:
```java
// Button aus Namespace holen
PushButton b = (PushButton)namespace.get("ButtonName123");
// Event Handler hinzufügen
b.getButtonPressListeners().add(new ButtonPressListener() {
    @Override
    public void buttonPressed(Button button) {
        // hier Code einfügen
    }
});
```

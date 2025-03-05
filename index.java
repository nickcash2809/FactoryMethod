class Dialog is
   
    abstract method createButton():Button
    method render() is
        
        Button okButton = createButton()
        okButton.onClick(closeDialog)
        okButton.render()

class WindowsDialog extends Dialog is
    method createButton():Button is
        return new WindowsButton()

class WebDialog extends Dialog is
    method createButton():Button is
        return new HTMLButton()

interface Button is
    method render()
    method onClick(f)

class WindowsButton implements Button is
    method render(a, b) is

    method onClick(f) is

class HTMLButton implements Button is
    method render(a, b) is
    method onClick(f) is
        
class Application is
    field dialog: Dialog

    method initialize() is
        config = readApplicationConfigFile()

        if (config.OS == "Windows") then
            dialog = new WindowsDialog()
        else if (config.OS == "Web") then
            dialog = new WebDialog()
        else
            throw new Exception("Error! Unknown operating system.")
    method main() is
        this.initialize()
        dialog.render()

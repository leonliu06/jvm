import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementScanner6;
import javax.lang.model.util.ElementScanner7;
import javax.tools.Diagnostic;

/**
 * Created by leon on 2017/9/25.
 */
public class NameChecker {

    private final Messager messager;

    NameCheckScanner nameCheckScanner = new NameCheckScanner();

    NameChecker(ProcessingEnvironment processingEnvironment){
        this.messager = processingEnvironment.getMessager();
    }

    public void checkNames(Element element){
        nameCheckScanner.scan(element);
    }

    private class NameCheckScanner extends ElementScanner7<Void, Void> {
        @Override
        public Void visitType(TypeElement e, Void p) {
            scan(e.getTypeParameters(), p);
            checkCamelCase(e, true);
            super.visitType(e, p);
            return null;
        }

        private void checkCamelCase(Element e, boolean initialCaps){
            String name = e.getSimpleName().toString();
            boolean previousUpper = false;
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);
            if(Character.isUpperCase(firstCodePoint)){
                previousUpper = true;
                if(!initialCaps){
                    messager.printMessage(Diagnostic.Kind.WARNING, " 名称" + name + " 应当以小写字母开头", e);
                    return;
                }
            }else if(Character.isLowerCase(firstCodePoint)){
                if(initialCaps){
                    messager.printMessage(Diagnostic.Kind.WARNING, " 名称" + name + " 应当以大写字母开头", e);
                }
            }else{
                conventional = false;
            }
        }

    }
}

package by.softclub.validator;


import lombok.Data;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.util.Optional;

@Data
@Named
@ViewScoped
@FacesValidator("titleValidator")
public class TitleValidator implements Validator {
    private FacesMessage message;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        if ((facesContext == null) || (uiComponent == null) || (value == null)) {
            throw new NullPointerException();
        }

        final String title = (String) Optional.ofNullable(value).orElse("");

        if (title.length() < 2 || title.length() > 20) {

            message = new FacesMessage ("Название должно содержать от 3 до 20 символов");

            throw new ValidatorException(message);
        }
    }
}

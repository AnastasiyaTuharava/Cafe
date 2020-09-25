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
import java.math.BigDecimal;
import java.util.Optional;

@Data
@Named
@ViewScoped
@FacesValidator("priceValidator")
public class PriceValidator implements Validator {
    private FacesMessage message;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        if ((facesContext == null) || (uiComponent == null)) {
            throw new NullPointerException();
        }

        final BigDecimal price = (BigDecimal) Optional.ofNullable(value).orElse(BigDecimal.ZERO);

        if (price.compareTo(BigDecimal.ZERO) <= 0) {

            message = new FacesMessage ("Цена должна быть выше 0");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);

            throw new ValidatorException(message);
        }
    }
}

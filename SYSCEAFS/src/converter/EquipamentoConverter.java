package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.ceafssystem.domain.equipamento.EquipamentoPO;

@FacesConverter(forClass = EquipamentoPO.class)
public class EquipamentoConverter implements Converter{
	@Override
	public Object getAsObject( FacesContext facesContext, UIComponent uiComponent, String value ) {
		if ( value != null && !value.isEmpty() ) {
			return (EquipamentoPO) uiComponent.getAttributes().get( value );
		}
		return null;
	}

	@Override
	public String getAsString( FacesContext facesContext, UIComponent uiComponent, Object value ) {
		if ( value instanceof EquipamentoPO ) {
			EquipamentoPO entity = (EquipamentoPO) value;
			if ( entity != null && entity instanceof EquipamentoPO && entity.getId() != null ) {
				uiComponent.getAttributes().put( entity.getId().toString(), entity );
				return entity.getId().toString();
			}
		}
		return "";
	}
}
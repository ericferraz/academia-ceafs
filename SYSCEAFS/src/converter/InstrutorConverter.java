package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.ceafssystem.domain.pessoa.InstrutorPO;

@FacesConverter(forClass = InstrutorPO.class)
public class InstrutorConverter implements Converter{
	@Override
	public Object getAsObject( FacesContext facesContext, UIComponent uiComponent, String value ) {
		if ( value != null && !value.isEmpty() ) {
			return (InstrutorPO) uiComponent.getAttributes().get( value );
		}
		return null;
	}

	@Override
	public String getAsString( FacesContext facesContext, UIComponent uiComponent, Object value ) {
		if ( value instanceof InstrutorPO ) {
			InstrutorPO entity = (InstrutorPO) value;
			if ( entity != null && entity instanceof InstrutorPO && entity.getId() != null ) {
				uiComponent.getAttributes().put( entity.getId().toString(), entity );
				return entity.getId().toString();
			}
		}
		return "";
	}
}
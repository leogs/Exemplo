package main;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Repositorio {

  public void insert(Object obj) throws Throwable {
    // Tenta obter nossa anota��o na classe
    DBTable persistable = obj.getClass().getAnnotation(DBTable.class);

    if (persistable != null){
      String tabela = persistable.table();
      
      // Map para montar o SQL campo/valor
      Map<String, String> keyAndValues = new HashMap<String, String>();

      // Obt�m os atributos da classe via reflection  
      Field[] fields = getFields(obj.getClass());
      
      for (Field field : fields) {
        // se os atributos s�o private, setamos ele como visible
        field.setAccessible(true);
        DBField coluna = field.getAnnotation(DBField.class);
        
        System.out.println(field.getName());

        // Se o atributo tem a anota��o
        if (coluna != null){
          // Verifica se est� vazio pra usar o nome do pr�prio atributo
        	String columnName = coluna.colummn();
        			
        	if (coluna.colummn().equals("")) {
        	  columnName = field.getName();  
        	}
       
          // Adiciona campo/valor no map
          keyAndValues.put(columnName, field.get(obj).toString());
        }
      }
 
      // Varre o map para montar o SQL
      String values = "";
      Set<String> keys = keyAndValues.keySet();
      for (String campo: keys) {
        if (!values.equals("")) {
        	values += ",";
        }
        String valor = keyAndValues.get(campo);
        values += campo +"='"+ valor +"'";
      }

      String sql = "INSERT INTO "+ tabela + " values("+ values +")";
      System.out.println("SQL---->"+ sql);
    } else {
    	System.out.println("Ei, voc� n�o est� usando Annotations!");
    }
  }

  // M�todo recursivo para obter os atributos da class e da superclasse
  public Field[] getFields(Class<?> c){
	  if (c.getSuperclass() != null){
	      // Chama o pr�prio m�todo para pegar os atributos da superclasse
	      Field[] superClassFields = getFields(c.getSuperclass());
	      
	      // Pega os atributos da pr�pria classe
	      Field[] thisFields = c.getDeclaredFields();
	 
	      // array com todos os atributos
	      Field[] allFields = new Field[superClassFields.length + thisFields.length];
	
	      // Copia os atributos da superclasse 
	      System.arraycopy(superClassFields, 0, allFields, 0, superClassFields.length);
	      
	      // Copia os atributos da classe atual
	      System.arraycopy(thisFields, 0, allFields, superClassFields.length, thisFields.length);
	   
	      return allFields;
	
	    // Se n�o tem superclasse, retorna os  pr�prios atributos
    } else {
    	return c.getDeclaredFields();
    }
  }
}

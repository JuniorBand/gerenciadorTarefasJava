/**
 * @author Júnior Bandeira
 * @since v1.0
 */

import lombok.Data;
//import lombok.Setter;

@Data
public class Tarefa {
	private String name;
	private boolean status;
	private String description;
	private int index;

	/**
	 * @param name String
	 * @param status boolean
	 * @param description String
	 * @param index int
	 */
	public void addTarefa(String name, boolean status, String description, int index){
		this.name = name;
		this.status = status;
		this.description = description;
		this.index = index;
	}

	public void showTarefa(){
		System.out.println("\n*=====* " + name + " *=====*");
		System.out.println("Descrição: " + description);
		if (status == true){System.out.println("Status: Concluída");}
		if (status == false){System.out.println("Status: Não Concluída");}
		System.out.println("ID: " + index +"\n");
	}


    // Métodos setters e getters (Caso: sem Lombok)
    // public void setName(String name) { this.name = name; }
    // public void setStatus(boolean status) { this.status = status; }
    // public void setDescription(String description) { this.description = description; }
    // public String getName() { return name; }
    // public boolean getStatus() { return status; }
    // public String getDescription() { return description; }
    // public int getId() { return index; }

}

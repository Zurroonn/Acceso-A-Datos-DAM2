package Apartado_b;

import java.util.List;

public interface MultasDAO {
	Multas getMultas(int id);
	void addMultas(Multas multas);
	void updateMultas(Multas multas);
	void deleteMultas(int id);
	List<Multas> getAllMultas();
}

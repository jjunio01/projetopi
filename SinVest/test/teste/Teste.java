package teste;

import br.com.simuladorinvestimentos.model.Investimento;
import br.com.simuladorinvestimentos.util.ErroSistema;
import java.io.IOException;
import java.util.List;

public class Teste {

    // ai é só jogar o atributo na sessão e recuperá-lo quando quiser. //métodos auxiliares que podem te ajudar: public FacesContext getFacesContext() { return FacesContext.getCurrentInstance(); } public HttpSession getSession() { return (HttpSession) getFacesContext().getExternalContext().getSession(false); } public HttpServletRequest getRequestSession() { return (HttpServletRequest) getFacesContext().getExternalContext().getRequest(); } 
    public static void main(String[] args) throws ErroSistema, IOException {

        

        List<Investimento> lista = null;

        
        System.out.println(lista);
        /*if (!(lista.isEmpty())) {

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) instanceof InvestPoupanca) {
                    System.out.println("----------------Poup");
                    System.out.println(lista.get(i));
                } else if (lista.get(i) instanceof InvestCDB) {
                    System.out.println("----------------CDB");
                    System.out.println(lista.get(i));
                } else if (lista.get(i) instanceof InvestLCI) {
                    System.out.println("----------------LCI");
                    System.out.println(lista.get(i));
                }

            }

        }*/
    }
}

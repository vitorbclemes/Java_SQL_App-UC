package apresentacao;

//JAVA.UTIL Imports
import java.util.Scanner;

//SISTEMA Imports
import Sistema.Controller;

public class Main {
    private static Controller controller = null;
    private static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args){
        
        try{
            controller = new Controller();
        }catch(Exception e){
            System.out.println("Falha no login");
        }

        int menuOp = 0;
        int banOp = 0;
        
        while(menuOp!=3){
            
            menu();
            
            menuOp = s.nextInt();
            if(menuOp == 1){
                manipulateArtigosMenu();
                banOp = s.nextInt();
                handleArtigos(banOp);
            }else if (menuOp == 2){
                manipulateEdicoesMenu();
                banOp = s.nextInt();
                handleEdicoes(banOp);
            }else if (menuOp == 3){
                System.out.println("Desconectando...");
            }
            else{
                System.out.println("Entrada invalida");
            }
        }
    }

    private static void menu() {
        System.out.println(" -- Sistema -- ");
        System.out.println("1 - Manipular artigos");
        System.out.println("2 - Manipular edicoes");
        System.out.println("3 - Sair");     
    }

    private static void manipulateArtigosMenu(){
        System.out.println("-- Opcoes para Artigo --");
        System.out.println("1 - Inserir novo Artigo.");
        System.out.println("2 - Selecionar Artigo pelo id");
        System.out.println("3 - Selecionar todos os Artigos");
        System.out.println("4 - Selecionar id e titulo de Artigos e id e Ano de sua respectiva edicao");
        System.out.println("5 - Remover Artigo pelo id");
        System.out.println("6 - Atualizar Artigo pelo id");
    }

    private static void manipulateEdicoesMenu(){
        System.out.println("-- Opcoes para Edicao --");
        System.out.println("1 - Inserir nova Edicao");
        System.out.println("2 - Selecionar Edicao pelo id");
        System.out.println("3 - Selecionar todas as Edicoes");
        System.out.println("4 - Selecionar as edicoes que ocorreram no estado do RS");
        System.out.println("5 - Remover Edicao pelo id");
        System.out.println("6 - Atualizar Edicao pelo id");
    }
    
    private static void handleArtigos(int operation){
        
        if(operation == 1){
            try{
                controller.inserirArtigo(controller.novoArtigo());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        else if(operation == 2){
            System.out.println("Id do artigo:");
            try{
                System.out.println(controller.selectArtigo(s.nextInt()).toString()); 
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        else if(operation == 3){
            try{
                controller.selectAllArtigo().forEach(artigo->{
                    System.out.println(artigo.toString());
                });
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        else if(operation == 4){
            try{
                System.out.println(controller.selectAllArtigoWithEdicoes());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        else if (operation == 5){
            System.out.println("Id do artigo:");
            try{
                controller.deletarArtigo(controller.selectArtigo(s.nextInt())); 
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        else if ( operation == 6){
            System.out.println("Id do artigo:");
            try{
                //Gambiarra pra tratar possiveis problemas de buffer
                int i = s.nextInt();
                s.nextLine();
                controller.atualizarArtigo(i); 
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        else{
            System.out.println("Operacao invalida");
        }
    }
    
    private static void handleEdicoes(int operation){
        if(operation == 1){
            try{
                controller.inserirEdicao(controller.novaEdicao());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        else if(operation == 2){
            System.out.println("Id da Edicao:");
            try{
                System.out.println(controller.selectEdicao(s.nextInt()).toString()); 
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        else if(operation == 3){
            try{
                controller.selectAllEdicao().forEach(edicao->{
                    System.out.println(edicao.toString());
                });
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(operation == 4){
            try{
                controller.selectAllWhereUFisRS().forEach(edicao->{
                    System.out.println(edicao.toString());
                });
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        else if (operation == 5){
            System.out.println("Id da Edicao:");
            try{
                controller.deletarEdicao(controller.selectEdicao(s.nextInt())); 
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        else if ( operation == 6){
            System.out.println("Id da Edicao:");
            try{
                //Gambiarra pra tratar possiveis problemas de buffer
                int i = s.nextInt();
                s.nextLine();
                controller.atualizarEdicao(i); 
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Operacao invalida");
        }
    }
}


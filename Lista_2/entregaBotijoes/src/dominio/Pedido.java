package dominio;

public class Pedido {
    private String enderecoEn;
    private String horaC;
    private String horaE;
    private int quatidade;
    private float total;
    private String status;
    private int codigo;
    private int cartaoDeCredito;

    public Pedido() {
        this.quatidade = 0;
        this.quatidade = 0;
    }

    public void setCartaoDeCredito(int cartaoDeCredito) {
        this.cartaoDeCredito = cartaoDeCredito;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEnderecoEn() {
        return enderecoEn;
    }

    public void setEnderecoEn(String enderecoEn) {
        this.enderecoEn = enderecoEn;
    }

    public String getHoraC() {
        return horaC;
    }

    public void setHoraC(String horaC) {
        this.horaC = horaC;
    }

    public int getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(int quatidade) {
        this.quatidade = quatidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private void calcularPreco(){
        total = quatidade*60;
    }

    private void horaPedido(){
        int hora = Integer.parseInt(String.valueOf(horaC.charAt(0)) + String.valueOf(horaC.charAt(1)));
        hora+=6;
        if(hora > 24) {
            hora -= 24;
            horaC += " AM";
        }else{
            if(hora <= 24 && hora >= 12) horaC += " PM";
            else horaC += " AM";
        }
        horaE = String.valueOf(hora);
        horaE += horaC.substring(2, horaC.length());
    }

    public String dadosPedido(){
        calcularPreco();
        horaPedido();
        return "Total: R$" + total + "\nHora de entrega: " + horaE;
    }

}

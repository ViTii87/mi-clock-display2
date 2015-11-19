
/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    // Atributo de tipo NumberDisplay para las horas
    private NumberDisplay horas = new NumberDisplay(24);
    // Atributo de tipo NumberDisplay para los minutos
    private NumberDisplay minutos = new NumberDisplay(60);
    // Atributo de tipo String para guardar la hora completa.
    private String horaFinal;
       
    /**
     * Constructor para crear un reloj con las horas y minutos fijadas a 0
     */
    public ClockDisplay()
    {
        // Fijamos mediante el metodo setValue de la clase NumberDisplay la hora por defecto a 0.
        horas.setValue(0);
        // Lo mismo con los minutos.
        minutos.setValue(0);
        // Actualizamos nuestro string al formato correcto
        horaBuena();
    }
    
    /**
     * Constructor que crea un reloj con las horas y minutos pasados como parametros
     */
    public ClockDisplay(int hora, int minuto)
    {
        // Fijamos mediante el metodo setValue de la clase NumberDisplay la hora introducida como parametro.
        horas.setValue(hora);
        // Lo mismo con los minutos.
        minutos.setValue(minuto);
        // Actualizamos nuestro string al formato correcto
        horaBuena();
    }
    
    /**
     * Metodo para fijar el tiempo del reloj pasandole como parametros la hora y los minutos
     */
    public void setTime(int horaNueva, int minutoNuevo)
    {
        // Fijamos mediante el metodo setValue de la clase NumberDisplay los minutos pasados como parametro.
        minutos.setValue(minutoNuevo);
        // Fijamos las horas mediante el metodo setValue()
        horas.setValue(horaNueva);
        // Llamamos a nuestro metodo para dejar la hora en el formato correcto.
        horaBuena();
    }
    
    /**
     * Metodo para mostrar un String que contendra la hora final de 5 digitos.
     */
    public String getTime()
    {
        // Ahora devolvemos el String con la hora correctamente fiajda.
        return horaFinal; 
    }
    
    /**
     * Metodo para avanzar un minuto en nuestro reloj.
     */
    public void timeTick()
    {
        // Incrementamos los minutos llamando a el metodo increment de la clase NumberDisplay.
        minutos.increment();
        // Obtengo los minutos mediante un metodo de la clase NumberDisplay y si son igual a 0 quiere decir que tenemos que incrementar una hora.
        if( minutos.getValue() == 0) {
            horas.increment();
        }
        // Actualizamos nuestro String despues de haber aplicado las operaciones en el formato correcto.
        horaBuena();
    }
    
    /**
     * Metodo para cambiar la hora al formato de 12 horas, lo llamaremos para actualizar nuestro String al formato correcto.
     */
    public void horaBuena(){
        // Primero miramos si el valor de las horas es menor a 12, en cuyo caso llevara A.M.
        if(horas.getValue() < 12){
            horaFinal = horas.getDisplayValue() + ":" + minutos.getDisplayValue() +  " A.M.";
        }
        else{
             // Si no la hora tendra que ser las 12 del mediodia con el formato P.M.
             if(horas.getValue() == 12){
                 // Devolvemos la hora con el nuevo formato
                 horaFinal = "12" + ":" + minutos.getDisplayValue() + " P.M.";
             }
             else{
                  // Por ultimo si no se da ninguna de las anteiores restaremos a 12 la hora para devolver el formato correcto de la tarde
                  // Ademas comprobaremos si el valor de restarle 12 es menor a 10 para añadirle un 0 o no.
                  if((horas.getValue() - 12) < 10){
                      horaFinal = "0" + (horas.getValue() - 12) + ":" + minutos.getDisplayValue() + " P.M.";   
                  }
                  else{
                      horaFinal = (horas.getValue() - 12) + ":" + minutos.getDisplayValue() + " P.M.";  
                  }     
             }
        }
    }
}
package domain;

import org.junit.Assert;
import org.junit.Test;
import domain.Materia;

public class InscripcionTest {
//
    @Test
    public void alumnoPuedeInscribirseAPdpSiAproboAyed(){

        Alumno unAlumno = new Alumno("Joel", "Freling", 2102913);
        Materia pdp = new Materia("pdp");
        Materia ayed = new Materia("ayed");
        unAlumno.agregarMateriasAprobadas(ayed);
        pdp.agregarCorrelativas(ayed);
        Inscripcion inscripcionAPdp = new Inscripcion(unAlumno, pdp);

        Assert.assertTrue(inscripcionAPdp.aprobada());
    }
    @Test
    public void alumnoNoPuedeInscribirseAPdpSiNoAproboAyed(){

        Alumno unAlumno = new Alumno("Joel", "Freling", 2102913);
        Materia pdp = new Materia("pdp");
        Materia ayed = new Materia("ayed");
        pdp.agregarCorrelativas(ayed);
        Inscripcion inscripcionAPdp = new Inscripcion(unAlumno, pdp);

        Assert.assertFalse(inscripcionAPdp.aprobada());
    }
    @Test
    public void alumnoPuedeInscribirseADdsSiAproboAdsYPdp(){

        Alumno unAlumno = new Alumno("Joel", "Freling", 2102913);
        Materia pdp = new Materia("pdp");
        Materia ads = new Materia("ads");
        Materia dds = new Materia("dds");
        dds.agregarCorrelativas(ads, pdp);
        unAlumno.agregarMateriasAprobadas(ads, pdp);
        Inscripcion inscripcionADds = new Inscripcion(unAlumno, dds);

        Assert.assertTrue(inscripcionADds.aprobada());
    }

}

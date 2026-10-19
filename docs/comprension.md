# Comprensión del diseño — Enunciado C
**Nombre:** Meridel Alexandra Calderon Galvis
**Fecha:** 19 de octubre de 2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Curso` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

>_`Curso` es abstracta porque se define forma común para todos los cursos, pero cada tipo de curso puede implementarlo de manera diferente. El método abstracto obliga a las subclases a tener su propia implementación._

---

### 2. Composición vs. agregación
Explica la diferencia entre `PlanEstudios ◆— Curso` (composición) y
`Facultad ◇— PlanEstudios` (agregación). ¿Qué pasaría con los cursos si se
elimina el plan? ¿Y con los planes si se elimina la facultad?

> _La composición es una relación fuerte, donde los cursos no pueden existir sin el plan de estudios. En cambio, la agregación permite que los planes existan independientemente de la facultad. Si se elimina plan los cursos se eliminarían también. Si se elimina la facultad, los planes seguirían existiendo._

---

### 3. Asociación
En `Estudiante — Curso`, ¿quién es dueño de quién? ¿Por qué se modela como
N:M y no como composición?

> _Ambos lados pueden tener múltiples instancias relacionadas. No hay un dueño claro, a diferencia de la composición donde un objeto contiene a otro. Se modela así porque un estudiante puede inscribirse en múltiples cursos y un curso puede tener múltiples estudiantes._

---

### 4. Dependencia
¿Por qué `Recomendador` **depende** de `HistorialAcademico` en lugar de
**tenerlo** como atributo? ¿Qué ventaja tiene pasar el servicio como
parámetro?

> _`Recomendador` depende de `HistorialAcademico` para permitir mayor flexibilidad. Pasar el servicio como parámetro facilita la prueba unitaria y el mantenimiento a largo plazo de la clase._

---

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] notas` en `Estudiante`
- `ArrayList<Curso>` en `PlanEstudios` y `Estudiante`

Explica por qué en cada caso se eligió esa estructura y no la otra. ¿Qué
pasa si el estudiante intenta registrar más notas que la capacidad del
arreglo?

> _Se eligió el arreglo porque el número de notas es fijo y conocido. Si el estudiante intenta registrar más notas que la capacidad del arreglo, se produciría un error en tiempo de ejecución. Mientras que al usar `ArrayList<Curso>`, la estructura puede crecer dinámicamente según sea necesario._
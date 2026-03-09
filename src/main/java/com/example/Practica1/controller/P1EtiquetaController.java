package com.example.Practica1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class P1EtiquetaController {

    public record Etiqueta(String id, String nombre, String categoria, String descripcion,
                           String sintaxis, String atributos, String codigoEjemplo,
                           String ejemploReal, String idAnterior, String idSiguiente) {}

    private final List<Etiqueta> catalogo = Arrays.asList(
            new Etiqueta("html", "<html>", "Estructura", "Elemento raíz que envuelve todo el contenido de la página web.", "<html>...</html>", "lang", "&lt;html lang=\"es\"&gt;\n  ...\n&lt;/html&gt;", "<i>(Invisible: Es la base de la página)</i>", "", "head"),
            new Etiqueta("head", "<head>", "Estructura", "Contiene metadatos, enlaces a hojas de estilo (CSS) y títulos.", "<head>...</head>", "Ninguno", "&lt;head&gt;\n  &lt;title&gt;Mi Web&lt;/title&gt;\n&lt;/head&gt;", "<i>(Invisible: Trabaja en el fondo)</i>", "html", "body"),
            new Etiqueta("body", "<body>", "Estructura", "Contiene todo el contenido visible de la página web.", "<body>...</body>", "Ninguno", "&lt;body&gt;\n  Hola Mundo\n&lt;/body&gt;", "<i>(Invisible: Es el contenedor de lo que ves)</i>", "head", "h1"),
            new Etiqueta("h1", "<h1>", "Texto", "Define el encabezado o título más importante de la página.", "<h1>...</h1>", "class, id", "&lt;h1&gt;Título Principal&lt;/h1&gt;", "<h1>Título Principal</h1>", "body", "p"),
            new Etiqueta("p", "<p>", "Texto", "Define un párrafo de texto.", "<p>...</p>", "class, id", "&lt;p&gt;Este es un párrafo.&lt;/p&gt;", "<p>Este es un párrafo.</p>", "h1", "span"),
            new Etiqueta("span", "<span>", "Texto", "Contenedor genérico en línea, útil para aplicar estilos a una parte del texto.", "<span>...</span>", "class, style", "&lt;p&gt;Texto &lt;span style=\"color:red;\"&gt;rojo&lt;/span&gt;&lt;/p&gt;", "<p>Texto <span style=\"color:red;\">rojo</span></p>", "p", "strong"),
            new Etiqueta("strong", "<strong>", "Texto", "Indica que el texto tiene fuerte importancia, mostrándolo en negrita.", "<strong>...</strong>", "class", "&lt;strong&gt;Aviso importante&lt;/strong&gt;", "<strong>Aviso importante</strong>", "span", "a"),
            new Etiqueta("a", "<a>", "Enlaces e imágenes", "Define un hipervínculo para navegar a otras páginas.", "<a href=\"url\">...</a>", "href, target", "&lt;a href=\"https://google.com\" target=\"_blank\"&gt;Ir a Google&lt;/a&gt;", "<a href=\"https://google.com\" target=\"_blank\">Ir a Google</a>", "strong", "img"),
            new Etiqueta("img", "<img>", "Enlaces e imágenes", "Inserta una imagen en la página.", "<img src=\"url\" alt=\"texto\">", "src, alt, width", "&lt;img src=\"https://www.w3.org/html/logo/badge/html5-badge-h-solo.png\" width=\"50\" alt=\"HTML5\"&gt;", "<img src=\"https://www.w3.org/html/logo/badge/html5-badge-h-solo.png\" width=\"50\" alt=\"HTML5\">", "a", "ul"),
            new Etiqueta("ul", "<ul>", "Listas", "Crea una lista desordenada (con viñetas o puntos).", "<ul>...</ul>", "class, id", "&lt;ul&gt;\n  &lt;li&gt;Manzana&lt;/li&gt;\n&lt;/ul&gt;", "<ul><li>Manzana</li></ul>", "img", "li"),
            new Etiqueta("li", "<li>", "Listas", "Define cada uno de los elementos dentro de una lista.", "<li>...</li>", "value", "&lt;li&gt;Elemento de lista&lt;/li&gt;", "<li>Elemento de lista</li>", "ul", "table"),
            new Etiqueta("table", "<table>", "Tablas", "Define el contenedor principal para crear una tabla de datos.", "<table>...</table>", "class, border", "&lt;table border=\"1\"&gt;\n  &lt;tr&gt;&lt;td&gt;Dato&lt;/td&gt;&lt;/tr&gt;\n&lt;/table&gt;", "<table border=\"1\"><tr><td>Dato</td></tr></table>", "li", "tr"),
            new Etiqueta("tr", "<tr>", "Tablas", "Define una fila (table row) dentro de una tabla.", "<tr>...</tr>", "class", "&lt;tr&gt;\n  &lt;td&gt;Celda 1&lt;/td&gt;\n&lt;/tr&gt;", "<table border=\"1\"><tr><td>Celda 1</td></tr></table>", "table", "td"),
            new Etiqueta("td", "<td>", "Tablas", "Define una celda de datos (table data) estándar en una tabla.", "<td>...</td>", "colspan, rowspan", "&lt;td&gt;Contenido&lt;/td&gt;", "<table border=\"1\"><tr><td>Contenido</td></tr></table>", "tr", "form"),
            new Etiqueta("form", "<form>", "Formularios", "Contenedor para crear un formulario de entrada de datos.", "<form action=\"url\">...</form>", "action, method", "&lt;form&gt;\n  &lt;input type=\"text\"&gt;\n&lt;/form&gt;", "<form><input type=\"text\"></form>", "td", "input"),
            new Etiqueta("input", "<input>", "Formularios", "Campo interactivo para que el usuario ingrese datos.", "<input type=\"tipo\">", "type, name, placeholder", "&lt;input type=\"text\" placeholder=\"Tu nombre\"&gt;", "<input type=\"text\" placeholder=\"Tu nombre\">", "form", "button"),
            new Etiqueta("button", "<button>", "Formularios", "Un botón en el que el usuario puede hacer clic.", "<button>...</button>", "type, disabled", "&lt;button type=\"button\"&gt;Presióname&lt;/button&gt;", "<button type=\"button\">Presióname</button>", "input", "video"),
            new Etiqueta("video", "<video>", "Multimedia", "Permite incrustar un reproductor de video en la página.", "<video src=\"url\"></video>", "src, controls, autoplay", "&lt;video controls width=\"200\"&gt;&lt;/video&gt;", "<video controls width=\"200\"></video>", "button", "header"),
            new Etiqueta("header", "<header>", "Semánticas", "Representa la cabecera de una página o sección (suele contener logos o títulos).", "<header>...</header>", "class, id", "&lt;header&gt;\n  &lt;h2&gt;Mi Blog&lt;/h2&gt;\n&lt;/header&gt;", "<header><h2>Mi Blog</h2></header>", "video", "nav"),
            new Etiqueta("nav", "<nav>", "Semánticas", "Define un bloque de enlaces de navegación principal.", "<nav>...</nav>", "class", "&lt;nav&gt;\n  &lt;a href=\"#\"&gt;Inicio&lt;/a&gt; | &lt;a href=\"#\"&gt;Acerca de&lt;/a&gt;\n&lt;/nav&gt;", "<nav><a href=\"#\">Inicio</a> | <a href=\"#\">Acerca de</a></nav>", "header", "")
    );

    // Ruta para la página principal (Catálogo completo)
    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("etiquetas", catalogo);
        return "index";
    }

    // Ruta dinámica para mostrar cada etiqueta individualmente
    @GetMapping("/etiqueta/{id}")
    public String verEtiqueta(@PathVariable String id, Model model) {
        Etiqueta etiquetaEncontrada = catalogo.stream()
                .filter(e -> e.id().equals(id))
                .findFirst()
                .orElse(catalogo.get(0));

        model.addAttribute("etiqueta", etiquetaEncontrada);
        return "detalle";
    }
}
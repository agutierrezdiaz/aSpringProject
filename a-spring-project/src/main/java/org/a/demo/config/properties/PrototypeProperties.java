package org.a.demo.config.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:templates/prototype.properties")
@ConfigurationProperties("prototype")
public class PrototypeProperties {

	private List<Menu> menu;

	public static class Menu {
		private String name;
		private String title;
		private String path;

		public Menu() {
		}

		public Menu(String name, String title, String path) {
			this.name = name;
			this.title = title;
			this.path = path;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		@Override
		public String toString() {
			return "Menu [name=" + name + ", title=" + title + ", path=" + path + "]";
		}
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Prototype [menu=" + menu + "]";
	}

}

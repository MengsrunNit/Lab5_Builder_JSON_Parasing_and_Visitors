/**
 * This class tests the JSONParser class, through GeometryBuilder, UnparseVisitor, and ToJSONVisitor
 * 
 * @author Flynn Nisbet, Mengsrun Nit
 * @since 10 - 20 - 2023
 */

package test.input.parser;
import input.builder.GeometryBuilder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;

import org.junit.jupiter.api.Test;
import input.components.*;
import input.exception.*;
import input.parser.*;
import input.visitor.*;
import org.json.*;

class JSONParserTest
{
	public static ComponentNode runFigureParseTest(String filename)
	{
		//Create GeometryBuilder to pass to JSONParser, parse
		GeometryBuilder geoBuild= new GeometryBuilder();
		JSONParser parser = new JSONParser(geoBuild);
		String figureStr = utilities.io.FileUtilities.readFileFilterComments(filename);
		return parser.parse(figureStr);
	}
	@Test
	void empty_json_string_test()
	{
		JSONParser parser = new JSONParser(null);
		assertThrows(ParseException.class, () -> { parser.parse("{}"); });
	}

	@Test
	void single_triangle_test()
	{
		//
		// The input String ("single_triangle.json") assumes the file is
		// located at the top-level of the project. If you move your input
		// files into a folder, update this String with the path:
		//                                       e.g., "my_folder/single_triangle.json"
		//

		// export the JSON document to the into the ComponentNode 

		//ComponentNode -> FigureNode, then unparse it through UnparseVisitor, print
		ComponentNode node = JSONParserTest.runFigureParseTest("src/single_triangle.json");
		FigureNode n = (FigureNode)node;
		StringBuilder sb = new StringBuilder();
		new UnparseVisitor().visitFigureNode(n, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(sb.toString());
		
		//Call toJSONVisitor on 
		ToJSONVisitor j = new ToJSONVisitor();
		JSONObject jo = (JSONObject) j.visitFigureNode(n, 1);
		System.out.println(jo.toString(1));
	}

	@Test
	void fully_connected_irregular_polygon_Test() {

		ComponentNode node = JSONParserTest.runFigureParseTest("src/fully_connected_irregular_polygon.json");
		FigureNode n = (FigureNode) node;
		StringBuilder sb = new StringBuilder();
		new UnparseVisitor().visitFigureNode(n, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(sb.toString());
		
		ToJSONVisitor j = new ToJSONVisitor();
		JSONObject jo = (JSONObject) j.visitFigureNode(n, 1);
		System.out.println(jo.toString(1));
		
	}

	@Test
	void crossing_symmetric_triangle_Test() {

		ComponentNode node = JSONParserTest.runFigureParseTest("src/crossing_symmetric_triangle.json");
		FigureNode n = (FigureNode) node;
		StringBuilder sb = new StringBuilder();
		new UnparseVisitor().visitFigureNode(n, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(sb.toString());

		ToJSONVisitor j = new ToJSONVisitor();
		JSONObject jo = (JSONObject) j.visitFigureNode(n, 1);
		System.out.println(jo.toString(1));

	}

	@Test
	void collinear_line_segment_Test() {

		ComponentNode node = JSONParserTest.runFigureParseTest("src/collinear_line_segments.json");
		FigureNode n = (FigureNode) node;
		StringBuilder sb = new StringBuilder();
		new UnparseVisitor().visitFigureNode(n, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(sb.toString());
		
		ToJSONVisitor j = new ToJSONVisitor();
		JSONObject jo = (JSONObject) j.visitFigureNode(n, 1);
		System.out.println(jo.toString(1));
		
	}
	@Test
	void pentagon_Test() {

		ComponentNode node = JSONParserTest.runFigureParseTest("src/pentagon.json");
		FigureNode n = (FigureNode) node;
		StringBuilder sb = new StringBuilder();
		new UnparseVisitor().visitFigureNode(n, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(sb.toString());

		ToJSONVisitor j = new ToJSONVisitor();
		JSONObject jo = (JSONObject) j.visitFigureNode(n, 1);
		System.out.println(jo.toString(1));
		
	}



	void testing_Test() {

		ComponentNode node = JSONParserTest.runFigureParseTest("src/testing.json");
		FigureNode n = (FigureNode) node;
		StringBuilder sb = new StringBuilder();
		new UnparseVisitor().visitFigureNode(n, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(sb.toString());
		
		ToJSONVisitor j = new ToJSONVisitor();
		JSONObject jo = (JSONObject) j.visitFigureNode(n, 1);
		System.out.println(jo.toString(1));

	}

	@Test
	void reflectedtraingle_Test() {

		ComponentNode node = JSONParserTest.runFigureParseTest("src/start.json");
		FigureNode n = (FigureNode) node;
		StringBuilder sb = new StringBuilder();
		new UnparseVisitor().visitFigureNode(n, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(sb.toString());
		
		ToJSONVisitor j = new ToJSONVisitor();
		JSONObject jo = (JSONObject) j.visitFigureNode(n, 1);
		System.out.println(jo.toString(1));

	}

	@Test
	void pant_figure_Test() {

		ComponentNode node = JSONParserTest.runFigureParseTest("src/pant_figure.json");
		FigureNode n = (FigureNode) node;
		StringBuilder sb = new StringBuilder();
		new UnparseVisitor().visitFigureNode(n, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(sb.toString());
		
		ToJSONVisitor j = new ToJSONVisitor();
		JSONObject jo = (JSONObject) j.visitFigureNode(n, 1);
		System.out.println(jo.toString(1));
	
	}

	@Test
	void shirt_figure_Test() {

		ComponentNode node = JSONParserTest.runFigureParseTest("src/shirt_figure.json");
		FigureNode n = (FigureNode) node;
		StringBuilder sb = new StringBuilder();
		new UnparseVisitor().visitFigureNode(n, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(sb.toString());

		ToJSONVisitor j = new ToJSONVisitor();
		int level = 1;
		JSONObject jo = (JSONObject) j.visitFigureNode(n, level);
		System.out.println(jo.toString(level));
	}
}
